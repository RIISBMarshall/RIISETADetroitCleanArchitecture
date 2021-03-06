package riis.etadetroit.presentationlayer.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import riis.etadetroit.presentationlayer.adapters.CompanyListAdapter;
import riis.etadetroit.R;
import riis.etadetroit.presentationlayer.presenter.MainActivityPresenter;


public class MainActivity extends Activity {

    private Menu menu;
    private boolean isListView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private Toolbar toolbar;
    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityPresenter = new MainActivityPresenter(this);
        setContentView(R.layout.activity_main);
        setUpRecyclerView();
        setUpActionBar();
    }

    private final CompanyListAdapter.OnItemClickListener onItemClickListener =
            new CompanyListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    mainActivityPresenter.callNextView(v, position, MainActivity.this);
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpRecyclerView() {
        isListView = true;
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        CompanyListAdapter mAdapter = new CompanyListAdapter(this, mainActivityPresenter);
        mAdapter.setOnItemClickListener(onItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setUpActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setActionBar(toolbar);
            getActionBar().setDisplayHomeAsUpEnabled(false);
            getActionBar().setDisplayShowTitleEnabled(true);
            getActionBar().setElevation(7);
        }
    }

    public void toggle() {
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {
            mStaggeredLayoutManager.setSpanCount(2);
            item.setIcon(R.drawable.ic_action_list);
            item.setTitle("Show as list");
            isListView = false;
        } else {
            mStaggeredLayoutManager.setSpanCount(1);
            item.setIcon(R.drawable.ic_action_grid);
            item.setTitle("Show as grid");
            isListView = true;
        }
    }
}
