package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner continents;

    ListView countries;

    TextView capitalCity, populationSize, officialLanguage, anthemName;

    String[][] countriesArr = { {"Nigeria", "Ethiopia", "Egypt", "Tanzania", "Kenya", "Uganda", "Algeria"},
                                {"China", "India", "Mongolia", "Pakistan", "Myanmar", "Yemen", "Iraq"},
                                {"Romania", "Ukraine", "Sweden", "Norway", "Germany", "Finland", "Poland"},
                                {"Venezuela", "Brazil", "Bolivia", "Chile", "Colombia", "Peru", "Suriname"}};

    String[][] countriesInfo = {{"Abuja", "206,630,269", "English", "Arise, O Compatriots"},
                                {"Addis Ababa", "109,224,414", "English", "March Forward, Dear Mother Ethiopia"},
                                {"Cairo", "100,075,480", "Arabic", "Bilady, Bilady, Bilady"},
                                {"Dodoma", "56,313,438", "Swahili, English, Arabic", "Mungu ibariki Afrika"},
                                {"Nairobi", "47,564,296", "English, Swahili", "O God of all creation"},
                                {"Kampala", "42,729,036", "English, Swahili", "Oh Uganda, Land of Beauty"},
                                {"Algiers", "43,600,000", "Arabic, Berber", "We Pledge"},
                                {"Beijing", "1,400,050,000", "Standard Chinese, Mongolian", "March of the Volunteers"},
                                {"New Delhi", "1,352,642,280", "Hindi, English", "Jana Gana Mana"},
                                {"Ulaanbaatar", "3,353,470", "Mongolian", "National anthem of Mongolia"},
                                {"Islamabad", "212,228,286", "English, Urdu", "The National Anthem"},
                                {"Naypyidaw", "53,582,855", "Burmese", "Till the End of the World"},
                                {"Sanaa", "28,498,683", "Arabic", "United Republic"},
                                {"Baghdad", "38,433,600", "Arabic, Kurdish", "My Homeland"},
                                {"Bucharest", "19,317,984", "Romanian", "Awaken thee, Romanian!"},
                                {"Kyiv", "41,660,982", "Ukrainian", "State Anthem of Ukraine"},
                                {"Stockholm", "10,343,403", "Swedish", "Thou ancient, thou free"},
                                {"Oslo", "5,432,580", "Norwegian, Sámi", "Yes, we love this country"},
                                {"Berlin", "83,166,711", "German", "Song of Germany"},
                                {"Helsinki", "5,528,737", "Finnish, Swedish, Sámi", "Our Land"},
                                {"Warsaw", "38,383,000", "Polish", "Poland Is Not Yet Lost"},
                                {"Caracas", "28,887,118", "Spanish", "Glory to the Brave People"},
                                {"Brasília", "210,147,125", "Portuguese", "Brazilian National Anthem"},
                                {"Sucre, La Paz", "11,428,245", "Spanish, Aymara, Quechua", "Himno Nacional de Bolivia"},
                                {"Santiago", "17,574,003", "Spanish", "Himno Nacional de Chile"},
                                {"Bogotá", "50,372,424", "Spanish, English", "National Anthem of the Republic of Colombia"},
                                {"Lima", "32,824,358", "Spanish", "National Anthem of Peru"},
                                {"Paramaribo", "575,990", "Dutch", "God be with our Suriname"}};

    int countriesPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continents = (Spinner) findViewById(R.id.continents);
        countries = (ListView) findViewById(R.id.countries);
        capitalCity = (TextView) findViewById(R.id.capitalCity);
        populationSize = (TextView) findViewById(R.id.populationSize);
        officialLanguage = (TextView) findViewById(R.id.officialLanguage);
        anthemName = (TextView) findViewById(R.id.anthemName);

        countriesPos = 0;

        continents.setOnItemSelectedListener(this);
        countries.setOnItemClickListener(this);
        countries.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> continentsAdp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                    getResources().getStringArray(R.array.continentsArr));
        continents.setAdapter(continentsAdp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long rowId) {
        if (pos != 0) {
            countries.setVisibility(View.VISIBLE);
            countriesPos = pos - 1;
            ArrayAdapter<String> countriesAdp = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, countriesArr[countriesPos]);
            countries.setAdapter(countriesAdp);
        }
        else {
            countries.setVisibility(View.INVISIBLE);
            // rest the tv values
            capitalCity.setText("Capitel city: ");
            populationSize.setText("Population size: ");
            officialLanguage.setText("Official language: ");
            anthemName.setText("Anthem name: ");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        capitalCity.setText("Capitel city: " + countriesInfo[position + (countriesPos * 7)][0]);
        populationSize.setText("Population size: " + countriesInfo[position + (countriesPos * 7)][1]);
        officialLanguage.setText("Official language: " + countriesInfo[position + (countriesPos * 7)][2]);
        anthemName.setText("Anthem name: " + countriesInfo[position + (countriesPos * 7)][3]);
    }
}