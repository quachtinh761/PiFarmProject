package vn.com.gant.pifarm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import vn.com.gant.pifarm.R;
import vn.com.gant.pifarm.SaveSharedPreference;
import vn.com.gant.pifarm.activities.Features;
import vn.com.gant.pifarm.activities.Forum;
import vn.com.gant.pifarm.activities.Login;
import vn.com.gant.pifarm.activities.ManageStaffs;
import vn.com.gant.pifarm.activities.ManageSwine;
import vn.com.gant.pifarm.activities.ReadCard;
import vn.com.gant.pifarm.activities.Statictis;
import vn.com.gant.pifarm.activities.SyncData;
import vn.com.gant.pifarm.activities.Vaccines;
import vn.com.gant.pifarm.activities.WriteCard;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActionBarFragment extends Fragment {


    ImageButton ibtnMenuBar;
    TextView txvLocationBar;
    ImageView imageLogoBarIcon;
    SearchView searchBar;
    View frmActionBar;

    public ActionBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frmActionBar = inflater.inflate(R.layout.fragment_action_bar, container, true);

        ibtnMenuBar = (ImageButton) frmActionBar.findViewById(R.id.ibtnMenuBar);
        txvLocationBar = (TextView) frmActionBar.findViewById(R.id.txvLocationBar);
        imageLogoBarIcon = (ImageView) frmActionBar.findViewById(R.id.imageLogoBarIcon);

        ibtnMenuBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Option image cliked", Toast.LENGTH_SHORT).show();

                PopupMenu optionMenu = new PopupMenu(getContext(), ibtnMenuBar);

                try {
                    Field[] fields = optionMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(optionMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                };

                optionMenu.getMenuInflater().inflate(R.menu.option_on_action_bar, optionMenu.getMenu());

                optionMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        String presentTitle = (String) item.getTitle();
                        switch (presentTitle){
                            case "Home":
                                derectTo(Features.class);
                                break;
                            case "Đọc thẻ":
                                derectTo(ReadCard.class);
                                break;
                            case "Ghi thẻ":
                                derectTo(WriteCard.class);
                                break;
                            case "Quản lý heo":
                                derectTo(ManageSwine.class);
                                break;
                            case "Thuốc và vaccine":
                                derectTo(Vaccines.class);
                                break;
                            case "Thống kê":
                                derectTo(Statictis.class);
                                break;
                            case "Hỏi đáp":
                                derectTo(Forum.class);
                                break;
                            case "Quản lý nhân viên":
                                derectTo(ManageStaffs.class);
                                break;
                            case "Đồng bộ dữ liệu":
                                derectTo(SyncData.class);
                                break;
                            case "Đăng xuất":
                                SaveSharedPreference.setUserName(getActivity(), "");
                                derectTo(Login.class);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                optionMenu.show();
            }
        });

        txvLocationBar.setText("");

        return frmActionBar;
    }

    private void derectTo(Class derection){
        Intent container = new Intent(getActivity(), derection);
        getActivity().startActivity(container);
        getActivity().finish();
    }

    public void setTitleBar(String titleBar){
        txvLocationBar.setText(titleBar);
    }
}
