package com.example.user.fragmentlist;


import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.List;


public class MainActivity extends AppCompatActivity implements ListItemFragment.OnHeadlineSelectedListener {
    private Fragment listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int container;
        if(isTablet(this)){
            setContentView(R.layout.tablet_main_view);
            container = R.id.containerItemList;
        }
        else{
            setContentView(R.layout.phone_main_view);
            container = R.id.container;
        }


        if (savedInstanceState == null) {
            listFragment = new ListItemFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(container, listFragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "listFragment", listFragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      listFragment = getSupportFragmentManager().getFragment(savedInstanceState,"listFragment");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onHeaderSelected(int position, List<Item> values) {

        Bundle bundle = new Bundle();
            bundle.putString("imageName", values.get(position).getImageId());
        bundle.putString("headerText", values.get(position).getHeader());
        DescriptionFragment fragment = new DescriptionFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(isTablet(this)){
            fragmentTransaction.add(R.id.descriptionImageView, fragment);
            fragmentTransaction.commit();
        }
        else{
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null).commit();}
    }

    public boolean isTablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }
}
