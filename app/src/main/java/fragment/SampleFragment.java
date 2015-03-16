package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidheroes.butterknifeproject.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SampleFragment extends Fragment{

    /* Declaring the variable with the Butterknife annotations */
    @InjectView(R.id.sample_fragment_textView)
    TextView sample_fragment_textview;

    /*
    *    Normal declaration of the variable
    *

    TextView sample_fragment_textview;

    */

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sample_fragment, null);

        /*
        * This is a regular implementation BEFORE BUTTERKNIFE
        *
        sample_fragment_textview = (TextView) view.findViewById(R.id.sample_fragment_textView);

        sample_fragment_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is a message from this fragment", Toast.LENGTH_SHORT).show();
            }
        });
        */

        /*
        * This is an implementation AFTER BUTTERKNIFE
        */

        /* For this injection you have to specify the source of the views */
        ButterKnife.inject(this, view);

        return view;
    }

    /* This is the event managed by Butterknife library */
    @OnClick(R.id.sample_fragment_textView)
    public void showToastMessage(){
        Toast.makeText(getActivity(), "This is a message from this fragment", Toast.LENGTH_SHORT).show();
    }

}
