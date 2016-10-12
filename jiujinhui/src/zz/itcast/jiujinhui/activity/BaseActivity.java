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
  //��ȡ��ǰ����id
	public abstract int getLayoutResID() ;
		

//��ʼ������
	public abstract void initData(); 
	
//��ʼ��������ΪListView��GridView������������
	public abstract void initListener();
		
   //��ʼ����ͼview
	public abstract void initView();
		   
	
	

	

}
