package io.github.noveo.artfly.task1.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.github.noveo.artfly.task1.app.events.SubmitEvent;
import io.github.noveo.artfly.task1.app.fragments.MainFragment;
import io.github.noveo.artfly.task1.app.fragments.SummaryFragment;
import io.github.noveo.artfly.task1.app.utils.TransactionUtilities;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    @Subscribe
    public void onSubmitEvent(SubmitEvent event) {
        TransactionUtilities.replaceFragment(getFragmentManager(), R.id.fragment_container,
                SummaryFragment.newInstance(event.name, event.surname, event.age));
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            TransactionUtilities.addFragment(getFragmentManager(),
                    R.id.fragment_container, MainFragment.newInstance());
        }
    }

    @Override
    public void onBackPressed() {
        if (!TransactionUtilities.popFragment(getFragmentManager())) {
            super.onBackPressed();
        }
    }

}
