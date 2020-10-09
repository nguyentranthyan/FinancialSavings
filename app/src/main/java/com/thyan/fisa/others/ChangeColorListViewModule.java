//package com.thyan.fisa.others;
//
//import android.app.Activity;
//import android.widget.TextView;
//
//import com.iuh.fisa.R;
//import com.iuh.fisa.entities.DanhMuc;
//import com.iuh.fisa.helper.DBHelper;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class ChangeColorListViewModule {
//    private static final String DOANHTHU = "doanhthu";
//
//    public static void changeColorListView(List<HashMap<String, String>> mapList, int position, Activity context,
//                                           DBHelper dbHelper, TextView textView) {
//        String srcImage = mapList.get(position).entrySet().iterator().next().getValue();
//        String imageName = context.getResources().getResourceName(Integer.parseInt(srcImage));
//        String[] strings = imageName.split("/");
//        String iconName = strings[1];
//        DanhMuc danhMuc = dbHelper.getByIcon_DanhMuc(iconName);
//        if(danhMuc.getLoaiDanhMuc().equals(DOANHTHU)) {
//            textView.setTextColor(context.getResources().getColor(R.color.colorLightBlue));
//        }
//        else {
//            textView.setTextColor(context.getResources().getColor(R.color.colorRed));
//        }
//    }
//}
