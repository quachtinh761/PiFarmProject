package vn.com.gant.pifarm.fragments;


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
import android.widget.Toast;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

import vn.com.gant.pifarm.R;


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
        searchBar = (SearchView) frmActionBar.findViewById(R.id.searchBar);

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
                        Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                optionMenu.show();
            }
        });

        txvLocationBar.setText("");

        return frmActionBar;
    }

    public void setTitleBar(String titleBar){
        txvLocationBar.setText(titleBar);
    }
}
