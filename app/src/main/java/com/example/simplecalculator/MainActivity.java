package com.example.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
    //private Button one,two,three,four,five,six,seven,eight,nine,ten,point,add,div,mul,sub;
    private Button button[];
    public EditText text;
    private int id[]={R.id.one,R.id.two,R.id.three,R.id.four,R.id.five,R.id.six,R.id.seven,
            R.id.eight,R.id.nine,R.id.zero,R.id.point,R.id.add,R.id.sub,R.id.mul,R.id.div,
            R.id.left,R.id.right,R.id.delect,R.id.back,R.id.equal};
    private EditText editText;
    private Cal cal_str;
    boolean equal=false;
    public MainActivity() {
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =new Button[id.length];
        for(int i=0;i<id.length;i++){
            button[i]=(Button) findViewById(id[i]);
            button[i].setOnClickListener(MainActivity.this);

            int height=this.getResources().getDisplayMetrics().heightPixels;//获取屏幕的高
            int width=this.getResources().getDisplayMetrics().widthPixels;
            button[i].setWidth(width/4);
            button[i].setHeight(height/6);
        }
    }
    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        Button btn =(Button) findViewById(view.getId());
        EditText print=(EditText) findViewById(R.id.print);
        if(btn.getId()==R.id.delect){
            print.setText(null);
        }
        else if(btn.getId()==R.id.back){
            char str[]=print.getText().toString().toCharArray();
            if(str.length>=1)
                print.setText(new String(str,0,str.length-1));
        }
        else if(btn.getId()==R.id.equal){
            String str=print.getText().toString();
            if(str.equals("11+11")||str.equals("99+1")){
                Toast.makeText(MainActivity.this, "其实你很帅哦,祝你双十一前脱单", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "app is made by 唐相儒", Toast.LENGTH_LONG).show();
            }
            equal=true;
            cal_str=new Cal(print,str+"=");
        }
        else{
            if(equal){
                equal=false;
                print.setText(null);
            }
            print.setText(print.getText()+btn.getText().toString());
        }
    }

}
