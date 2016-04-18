package co.hackdevmentalists.abhinav.rembrasio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twitter.sdk.android.tweetcomposer.Card;

import java.util.List;

/**
 * Created by Shuvam Ghosh on 3/25/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    private static final String TAG = "SAMPLE TAG" ;
    List<Person> persons;
    private Context mContext ;

    RVAdapter(List<Person> persons, Context context){
        this.persons = persons;
        mContext = context ;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v, mContext);
        return pvh;

    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personAge.setText(persons.get(i).age);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Context mContext ;
        CardView cv;

        TextView personName;
        TextView personAge;
        ImageView personPhoto;
        PersonViewHolder(View itemView, Context context) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

            personPhoto.setOnClickListener(this);
            mContext = context ;

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext.getApplicationContext(), CardActivity.class) ;
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }

    }

}