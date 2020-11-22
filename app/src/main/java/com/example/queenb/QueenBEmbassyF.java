package com.example.queenb;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class QueenBEmbassyF extends Fragment { // Fragment

    ListView listview;

    int images[] = {R.drawable.magalofir, R.drawable.savyon, R.drawable.galiyefet, R.drawable.elizabethbr,
            R.drawable.hannashti, R.drawable.liakanari, R.drawable.yulirozner, R.drawable.stavhaike,
            R.drawable.noanir, R.drawable.mayasmov, R.drawable.yuvalbenezra, R.drawable.amaliasucary};

    String names[] = {
            "מגל אופיר",
            "סביון פלורנס נחמן",
            "גלי יפת",
            "אליזבת בראודסקי",
            "חנה שטילמן",
            "ליה כנרי",
            "יולי רוזנר",
            "סתיו חייקה",
            "נועה ניר",
            "מאיה סמובסקי",
            "יובל בן עזרא",
            "עמליה סוכרי",
    };
    String ages[] = {"גיל: 15", "גיל: 15", "גיל: 15", "גיל: 15", "גיל: 15", "גיל: 15",
            "גיל: 15", "גיל: 16", "גיל: 14", "גיל: 14", "גיל: 14", "גיל: 15"};

    String locations[] = {"סניף ירושלים", "סניף ירושלים", "סניף ירושלים", "סניף ירושלים", "סניף ירושלים", "סניף תל אביב",
            "סניף תל אביב", "סניף ירושלים", "סניף חיפה", "סניף חיפה", "סניף חיפה", "סניף תל אביב"};

    String phone_numbers[] = {"+972 528982213", "+972 552281405", "+972 587655524", "+972 534212372",
            "+972 585372245", "+972 585551354", "+972 532741014", "+972 548170365",
            "+972 543094460", "+972 586714286", "+972 549538121", "+972 527202019"};

    String instagram_links[] = {"no account", "http://instagram.com/_u/savyon_nachman_", "no account",
            "http://instagram.com/_u/jackjack_167", "http://instagram.com/_u/hannah._.1200", "http://instagram.com/_u/wehateliya_", "no account",
            "http://instagram.com/_u/stavhaike", "no account", "no account", "http://instagram.com/_u/doby_fangirl",
            "http://instagram.com/_u/amalia.sucary"}; //todo try2 after savyon and before jackjack- get link

    String loved_about_queenb[] = {"שיש אווירה כיפית, שלא צריך באמת להספיק איזה חומר למבחן. שבאמת מתחברים לבנות ולמדריכות מעבר לשיעורים",
            "it is a GIRLS CLUB :)",
            "את החיבור בין החניכות למדריכות ודרך העברת השיעורים, האווירה, וההקאתונים כמובן!",
            "אי אפשר לנסח במשפט אחד את מה שאהבתי בקווין בי! המדריכות המדהימות, הקבוצה המגובשת, ופעילויות והשיעורים.",
            "התוכן שהיה רלוונטי, היחס האישי והקבוצה המדהימה שהיתה לנו!",
            "את המדריכות- הן תמכו בנו בטירוף ותמיד הרגשתי שאכפת להן",
            "האווירה , הפעילויות , דרך הלמידה, חברות ובקיצור הכל!!!",
            "את האנשים ואת הלמידה",
            "את טיולי ההעשרה",
            "אהבתי ללמוד דברים חדשים ולפגוש חברות חדשות",
            "את המדריכות ואת החברות",
            "ללמוד נושא שלא ידעתי קודם ולהכיר חברות חדשות."}; //todo EDIT what they wrote to be more official

    String recommendQueenb[] = {"התכנית גרמה לי להתאהב במדעי המחשב, שזה תחום שלא הרבה בנות הולכות אליו, וזה לא כי הן לא יכולות. אני עכשיו בכיתה י' במגמת מדעי המחשב ואני מבינה כמה התכנית עזרה לי",
            "אני עכשיו במגמת מדעי המחשב כולם נורא מסתבכים רק אני יושבת רגל על רגל כי סיימתי את כל התרגילים",
            "כי זה פותח כל כך הרבה דלתות בחיים ומראה עולם כל כך גדול ומעניין, הזדמנות ענקית לכל נערה להתאהב!",
            "קודם כל אין סיבה שלא ללכת! א. העצמה נשית זה תמיד טוב. ב. כיף ללמוד את החומר בצורה כל כך כיפיית ולהגיע לכיתה י כבר בשיעור הראשון את יכולה לעזור לחברות שמתקשות.",
            "כיף להכיר עוד בנות שנמצאות איתך באותו ראש ולעבור תהליך של למידה ביחד",
            "זו חוויה מדהימה, נפתחתי למשהו שנבהלתי ממנו קודם והכרתי חברות חדשות ",
            "אני חושבת שQueenB זו תכנית מדהימה שנותנת היזדמנות עצומה לקראת העתיד שלך ומקפצה גדולה לאזרחות.",
            "עוזר ברמות לביטחון העצמי, מכירים חברות לחיים שומעות על בנות אחרות שגורמות לך להאמין שגם את יכולה לעשות הכל",
            "כדי להעשיר את הידע ולדעת תחומים אחרים חוץ ממה שלומדים בבית הספר",
            "ממש כיף ללמוד איך לתכנת אתר אינטרנט ולראות התוצאות פועלות - בעיקר כשאת מקבלת משימה ועושה אותה לבד!",
            "בגלל המדריכות והחברה",
            "אני ממליצה ללכת לקווין בי מכיון שלומדים נושא חדש ונוסף לכך זה פותח דלתות בהמשך."}; //todo EDIT what they wrote to be more official + מספר 11 כתבה לא יודעת במקור

    List<ItemsModel> listItem = new ArrayList<>();
    CustomAdapter customAdapter;

    public QueenBEmbassyF() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static QueenBEmbassyF newInstance() {
        QueenBEmbassyF fragment = new QueenBEmbassyF();
        //the way to pass arguments between fragments
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_queenb_embassy, container, false);


        //initialization of the list view (list of buttons)
        listview = v.findViewById(R.id.listview);

        for (int i = 0; i < names.length ; i++){
            ItemsModel itemsModel = new ItemsModel(names[i], ages[i], locations[i], images[i],
                    phone_numbers[i], instagram_links[i], loved_about_queenb[i], recommendQueenb[i]); //todo try1+2
            listItem.add(itemsModel);
        }
        //required for handling the listView
        customAdapter = new CustomAdapter(listItem, getActivity());
        listview.setAdapter(customAdapter);
        return v;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getActivity().getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFiltered;
        private Context context;

        //Constructor
        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }

        //Methods
        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_items, null);
            ImageView imageView = view.findViewById(R.id.images);
            MaterialCardView card =view.findViewById(R.id.cardList);

            TextView itemNameView = view.findViewById(R.id.name);
            TextView itemAgeView = view.findViewById(R.id.age);
            TextView itemLocationView = view.findViewById(R.id.location);

            imageView.setImageResource(itemsModelListFiltered.get(position).getImage_of_quote());
            itemNameView.setText(itemsModelListFiltered.get(position).getName());
            itemAgeView.setText(itemsModelListFiltered.get(position).getAge());
            itemLocationView.setText(itemsModelListFiltered.get(position).getLocation());

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //passing the data about the specific girl to the other fragment
                    ItemsModel item = itemsModelListFiltered.get(position);
                    ItemViewF itemViewGirl = new ItemViewF();
                    Bundle args = new Bundle();
                    args.putSerializable("item", item);
                    itemViewGirl.setArguments(args);

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            itemViewGirl).addToBackStack(null).commit();
                }
            });

            return view;
        }


        //for searching
        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    } else {
                        String searchStr = constraint.toString().toLowerCase(); //todo why lower
                        List<ItemsModel> resultData = new ArrayList<>();
                        for (ItemsModel itemsModel : itemsModelList) {
                            if (itemsModel.getName().contains(searchStr) |
                                    itemsModel.getLocation().contains(searchStr)) { //todo changed a liitle
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }
}