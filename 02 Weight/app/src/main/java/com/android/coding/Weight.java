package com.android.coding;

/* import相关class */ 
import android.R.string;
import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText; 
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Weight extends Activity {
    /** Called when the activity is first created. */
	public static String sex="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState); 

    	    /* 载入main.xml Layout */
    	    setContentView(R.layout.main); 
    	    /* 以findViewById()取得Button对象，并加入onClickListener */ 
    	    Button b1 = (Button) findViewById(R.id.btn_calculate);    	    
    	    b1.setOnClickListener(new OnClickListener() {		
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					EditText et = (EditText)findViewById(R.id.et_height);

					double height=Double.parseDouble(et.getText().toString());
		    	    /*取得选择的性别*/ 		    	    
		    	    RadioGroup rg = (RadioGroup)findViewById(R.id.rg_sex);
		    	    rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {						
						@Override
						public void onCheckedChanged(RadioGroup arg0, int checkedId) {
							// TODO Auto-generated method stub
							if(checkedId==R.id.rb_male){  
								sex="M";
			                }  
			                else{  
			                	sex="F";  
			                }  
						}
					});
		    	    /*new一个Intent对象，并指定class*/
	    	        Intent intent = new Intent(); 
	    	        intent.setClass(Weight.this,Result.class); 
	    	        /*new一个Bundle对象，并将要传递的数据传入*/
	    	        Bundle bundle = new Bundle();
	    	        bundle.putDouble("height",height);
	    	        bundle.putString("sex",sex); 
	    	        /*将Bundle对象assign给Intent*/ 
	    	        intent.putExtras(bundle); 
	    	        /*调用Activity*/
	    	        startActivity(intent); 
				}
			});
    	    }
    	  }