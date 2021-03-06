package riis.etadetroit.presentationlayer.view;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.transition.Transition;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import riis.etadetroit.R;
import riis.etadetroit.presentationlayer.adapters.RouteCursorAdapter;
import riis.etadetroit.presentationlayer.adapters.TransitionAdapter;
import riis.etadetroit.presentationlayer.presenter.CompanyDetailsPresenter;

public class CompanyDetailsActivity extends Activity {

    public static final String EXTRA_PARAM_ID = "place_id";
    private ListView mList;
    private ImageView mImageView;
    private TextView mTitle;
    private LinearLayout mTitleHolder;

    private Cursor routeCursor;
    private int defaultColor;
    private String companyName;
    private int companyImageResourceId;
    private CompanyDetailsPresenter companyDetailsPresenter;
    private Palette mPalette;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        initializeAttributes();
        initializeViews();
        setUpAdapter();
        loadBusCompany();
        windowTransition();
        getPhoto();

        mList.setOnItemClickListener(companyDetailsPresenter.getRouteListClickListener(companyName,
                mPalette, defaultColor));
    }

    public void initializeAttributes() {
        companyDetailsPresenter = new CompanyDetailsPresenter(this);
        int companyPosition = getIntent().getIntExtra(EXTRA_PARAM_ID, 0);
        companyName = companyDetailsPresenter.getCompanyName(companyPosition);
        companyImageResourceId = companyDetailsPresenter.getCompanyImageResourceId(companyPosition);
        defaultColor = getResources().getColor(R.color.primary_dark);
    }

    public void initializeViews() {
        mList = (ListView) findViewById(R.id.list);
        mImageView = (ImageView) findViewById(R.id.busImage);
        mTitle = (TextView) findViewById(R.id.textView);
        mTitleHolder = (LinearLayout) findViewById(R.id.busNameHolder);
    }

    public void setUpAdapter() {
        routeCursor = companyDetailsPresenter.getRoutes(companyName);
        RouteCursorAdapter routeAdapter = new RouteCursorAdapter(this, routeCursor);
        mList.setAdapter(routeAdapter);
    }

    public void loadBusCompany() {
        mTitle.setText(companyName);
        mImageView.setImageResource(companyImageResourceId);
    }

    public void windowTransition() {
        getWindow().getEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                getWindow().getEnterTransition().removeListener(this);
            }
        });
    }

    public void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(), companyImageResourceId);
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        mPalette = new Palette.Builder(photo).generate();
        applyPalette(mPalette);
    }

    private void applyPalette(Palette mPalette) {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        mTitleHolder.setBackgroundColor(mPalette.getMutedColor(defaultColor));
    }

}
