package co.hackdevmentalists.abhinav.rembrasio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FriendsActivity extends AppCompatActivity{

    private List<Person> persons;

    private CardView cardView;
    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);


        initializeData();
        rv = (RecyclerView)findViewById(R.id.rv);
        cardView=(CardView)findViewById(R.id.cv);


        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(persons, getBaseContext());
        rv.getItemAnimator().setAddDuration(1000);
        rv.setAdapter(adapter);
    }

    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Shuvam Ghosh", "21 years old", R.drawable.image));
        persons.add(new Person("Abhinav Das", "19 years old", R.drawable.image));
        persons.add(new Person("Ashwini Purohit", "45 years old", R.drawable.image));
        persons.add(new Person("Rishi Raj", "21 years old", R.drawable.image));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.image));


    }

}
