package riis.etadetroit.presentationlayer.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import riis.etadetroit.R;
import riis.etadetroit.presentationlayer.presenter.RouteDetailsPresenter;

public class RouteDetailsActivity extends Activity {

    public static final String EXTRA_ROUTE = "route";
    public static final String EXTRA_COLOR = "color";
    private TextView routeDetails;
    private String route;
    private String routeId;
    private RouteDetailsPresenter routeDetailsPresenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        routeDetailsPresenter = new RouteDetailsPresenter(this);
        intent = getIntent();
        route = intent.getStringExtra(EXTRA_ROUTE);
        routeDetails = (TextView) findViewById(R.id.routeDetails);
        setBackgroundColor();
        setRouteDetails();
        setRouteId();
        showRouteStops();
    }

    public void setRouteDetails() {
        routeDetails.setText(routeDetailsPresenter.getRouteDetails(route));
    }

    public void setRouteId() {
        routeId = routeDetailsPresenter.getRouteId(route);
    }

    public void showRouteStops() {
        Cursor routeStopsCursor = routeDetailsPresenter.getRouteStops(routeId);

        CursorAdapter routeStopsCursorAdapter = new SimpleCursorAdapter(this, R.layout.adapter_route_stops_cursor, routeStopsCursor, new String[]{"stop_name"},
                new int[]{R.id.list_content}, 0);
        ListView stopList = (ListView) findViewById(R.id.stopList);
        stopList.setAdapter(routeStopsCursorAdapter);
    }

    public void setBackgroundColor() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.route_details_layout);
        layout.setBackgroundColor(intent.getIntExtra(EXTRA_COLOR, getResources().getColor(R.color.photo_tint)));
    }
}
