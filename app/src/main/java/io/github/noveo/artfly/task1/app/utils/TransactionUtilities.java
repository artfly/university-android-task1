package io.github.noveo.artfly.task1.app.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by arty on 01.03.16.
 */
public final class TransactionUtilities {

    public static void replaceFragment(FragmentManager manager, int container, Fragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void addFragment(FragmentManager manager, int container, Fragment fragment) {
        manager.beginTransaction().add(container, fragment).commit();
    }

    public static boolean popFragment(FragmentManager manager) {
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
            return true;
        }
        return false;
    }
}
