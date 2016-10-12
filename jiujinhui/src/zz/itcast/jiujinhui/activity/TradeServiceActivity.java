package zz.itcast.jiujinhui.activity;

import java.util.ArrayList;

import zz.itcast.jiujinhui.R;
import zz.itcast.jiujinhui.fragment.BuyChartFragment;
import zz.itcast.jiujinhui.fragment.EveryDayTradeRecordFragment;
import zz.itcast.jiujinhui.fragment.NowTradeRecoedFragment;
import zz.itcast.jiujinhui.fragment.SaleChartFragment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class TradeServiceActivity extends BaseActivity {
      
	//交易曲线
	@ViewInject(R.id.tabs)
	private PagerSlidingTabStrip tabs;
	@ViewInject(R.id.trade_pager)
	private ViewPager trade_pager;
	
	//
	//交易曲线
	private ArrayList<Fragment> fragmentsList1;
	//买入卖出曲线
	@ViewInject(R.id.tabs_buysale)
	private PagerSlidingTabStrip tabs_buysale;
	@ViewInject(R.id.buy_sale_pager)
	private ViewPager buy_sale_pager;
	
		private ArrayList<Fragment> fragmentsList2;
	@ViewInject(R.id.hscrollview)
	private HorizontalScrollView hscrollview;
	@ViewInject(R.id.ll_scroll)
	
	private LinearLayout ll_scroll;
	@ViewInject(R.id.tv_back)
	private ImageView tv_back;
	@ViewInject(R.id.tv__title)
	private TextView tv__title;
     //定义一个Handler对象
	private final Handler handler=new Handler();
	//当前滚动距离
	int currentX=0;
	
	//实现滚动线程
	private Runnable hscrollRunnable=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//判断宽度
			int off=ll_scroll.getMeasuredWidth();
		
			hscrollview.scrollBy(off, 0);
			
			handler.postDelayed(this, 4000);
			
		}
	};
	@Override
	public void initView() {
		// TODO Auto-generated method stub
         ViewUtils.inject(this);
         tv__title.setText("交易服务");
         handler.post(hscrollRunnable);
	}
	@Override
	public int getLayoutResID() {
		// TODO Auto-generated method stub
		return R.layout.frag_trade_service;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		fragmentsList1 = new ArrayList<Fragment>();
		fragmentsList1.add(new NowTradeRecoedFragment());
		fragmentsList1.add(new EveryDayTradeRecordFragment());
		fragmentsList2=new ArrayList<Fragment>();
		fragmentsList2.add(new SaleChartFragment());
		fragmentsList2.add(new BuyChartFragment());
		trade_pager.setAdapter(new MypagerAdapter(getSupportFragmentManager(),
				fragmentsList1));
		buy_sale_pager.setAdapter(new MyBuySalepagerAdapter(getSupportFragmentManager(),
				fragmentsList2));
		tabs.setViewPager(trade_pager);
		tabs_buysale.setViewPager(buy_sale_pager);
		tabs.setShouldExpand(true);
		tabs_buysale.setShouldExpand(true);
	}
   //交易曲线图适配器
	public class MypagerAdapter extends FragmentPagerAdapter {
		private ArrayList<Fragment> fragmentsList1;

		public MypagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
			super(fm);
			this.fragmentsList1 = fragments;
		}

		public MypagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		private final String[] titles1 = { "实时", "每天" };
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titles1[position];
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return fragmentsList1.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return titles1.length;
		}

	}
	//买入卖出图标适配器
	public class MyBuySalepagerAdapter extends FragmentPagerAdapter {
		private ArrayList<Fragment> fragmentsList2;

		public MyBuySalepagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
			super(fm);
			this.fragmentsList2 = fragments;
		}

		public MyBuySalepagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
		private final String[] titles2 = { "卖出", "买入" };
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titles2[position];
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return fragmentsList2.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return titles2.length;
		}

	}
	@Override
	public void initListener() {
		// TODO Auto-generated method stub
      tv_back.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
            switch (v.getId()) {
			case R.id.tv_back:
				finish();
				break;

			default:
				break;
			}  
	}


}
