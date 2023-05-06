package com.svalero.happdeporteandroid.contract;

public interface UserDeleteContract {

    interface Model {
        interface OnDeleteUserListener {
            void onDeleteSuccess();
            void onDeleteError(String message);
        }
        void deleteUser(long userId, OnDeleteUserListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void deleteUser(long userId);
    }
}
