package zz.itcast.jiujinhui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;

public abstract class BaseActivity extends FragmentActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(getLayoutResID());
		initView();
		initListener();
		initData();
       
		
		
		
	}
  //获取当前布局id
	public abstract int getLayoutResID() ;
		

//初始化数据
	public abstract void initData(); 
	
//初始化监听，为ListView，GridView等设置适配器
	public abstract void initListener();
		
   //初始化视图view
	public abstract void initView();
		   
	
	

	

}
