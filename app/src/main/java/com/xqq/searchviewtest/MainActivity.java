package com.xqq.searchviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public SearchView sv;
    public ListView lv;

    private final String[] mStrings = new String[]{"aaaaaa", "bbbbbb", "cccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv = (SearchView)findViewById(R.id.sv);
        lv = (ListView)findViewById(R.id.lv);

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1));
        // 设置listView启用过滤
        lv.setTextFilterEnabled(true);

        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        // 设置该SearchView是否显示搜索按钮
        sv.setSubmitButtonEnabled(true);
        // 设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
        // 设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 用户输入字符时激发该方法
            @Override
            public boolean onQueryTextSubmit(String newText) {
                // newText 不是字符串长度为0的字符串
                if(TextUtils.isEmpty(newText)){
                    // 清除listView的过滤
                }else {
                    // 使用用户输入的内容对listView的列表项进行过滤
                    lv.setFilterText(newText);
                }
                return true;
            }

            // 单击搜索该按钮时激发该方法
            @Override
            public boolean onQueryTextChange(String query) {
                // 实际应用中应该在该方法内部执行实际查询
                Toast.makeText(MainActivity.this,
                        "你的选择是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
