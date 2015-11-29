package cyource.manasrawat.cycripter;

//Imports

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RemoteViews;
import android.widget.Switch;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cyanogenmod.app.CMStatusBarManager;
import cyanogenmod.app.CustomTile;
import cyanogenmod.os.Build;

//Class
public class MainActivity extends AppCompatActivity {

    Switch switch1;
    FloatingActionsMenu fam;
    RadioButton rb;
    RadioButton rb2;
    TextView textview;

    EditText input;
    EditText input2;
    EditText input3;
    EditText input4;
    EditText input5;

    String inputString;
    String inputString2;
    String inputString3;
    String inputString4;
    String inputString5;

    TextView output;
    TextView output2;
    TextView output3;
    TextView output4;
    TextView output5;

    String inputln = null;
    String inputln2 = null;
    String inputln3 = null;
    String inputln4 = null;
    String inputln5 = null;

    Matcher inputMatch = null;
    Matcher inputMatch2 = null;
    Matcher input2Match = null;
    Matcher input2Match2 = null;
    Matcher input3Match = null;
    Matcher input3Match2 = null;
    Matcher input4Match = null;
    Matcher input4Match2 = null;
    Matcher input5Match = null;
    Matcher input5Match2 = null;

    Double parse = null;
    Double parse2 = null;
    Double parse3 = null;
    Double parse4 = null;
    Double parse5 = null;

    String toString = null;
    String toString2 = null;
    String toString3 = null;
    String toString4 = null;
    String toString5 = null;

    Intent intent = null;
    Intent intent2 = null;
    Intent intent3 = null;
    Intent intent4 = null;
    Intent intent5 = null;

    //onCreate (Method-0)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (Build.CM_VERSION.SDK_INT >= Build.CM_VERSION_CODES.BOYSENBERRY) {
            final int CUSTOM_TILE_ID = 1;
            RemoteViews contentView = new RemoteViews(getPackageName(),
                    R.layout.remote_view);

            Intent cycripterIntent = getPackageManager().getLaunchIntentForPackage("cyource.manasrawat.cycripter");
            PendingIntent intent = PendingIntent.getActivity(this, 0,
                    cycripterIntent, 0);
            contentView.setOnClickPendingIntent(R.id.launch, intent);

            CustomTile.RemoteExpandedStyle remoteExpandedStyle =
                    new CustomTile.RemoteExpandedStyle();
            remoteExpandedStyle.setRemoteViews(contentView);
            Intent settingsIntent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            settingsIntent.setData(Uri.parse("package:" + "cyource.manasrawat.cycripter"));
            CustomTile customTile = new CustomTile.Builder(this)
                    .setLabel("Cycripter")
                    .setIcon(R.drawable.ic_code_white_36dp)
                    .setExpandedStyle(remoteExpandedStyle)
                    .setContentDescription("Description of content for expanded style")
                    .setOnSettingsClickIntent(settingsIntent)
                    .build();
            CMStatusBarManager.getInstance(this)
                    .publishTile(CUSTOM_TILE_ID, customTile);

            if (toolbar != null) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Cycripter");
            }
        }
    }

    public void coreSwitch() {
        if (switch1.isChecked()) {
            fam.setVisibility(View.VISIBLE);
            fam.animate().translationY(0);
            switch1.setChecked(true);
            textview.setText("Showing Floating Menu");

        } else {
            fam.animate().translationY(250);
            switch1.setChecked(false);
            textview.setText("Hiding Floating Menu");
        }
    }

    public void switched(View v) {

        switch1 = (Switch) findViewById(R.id.switch1);
        fam = (FloatingActionsMenu) findViewById(R.id.fam);
        textview = (TextView) findViewById(R.id.textview);

                coreSwitch();

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            coreSwitch();
        }
        });
    }

    public void core(String inputln, Matcher inputMatch, Matcher inputMatch2, Double parse, String toString, Intent intent, EditText input, String inputString, TextView output, String line) {

        this.inputln = inputln;
        this.inputMatch = inputMatch;
        this.inputMatch2 = inputMatch2;
        this.parse = parse;
        this.toString = toString;
        this.intent = intent;
        this.input = input;
        this.inputString = inputString;
        this.output = output;

        if (inputString.matches("android.print\\(\".+\"\\)"))

        {

            inputln = inputString;
            inputln = inputln.substring(15, inputString.length() - 2);

            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));
            output.setText(inputln);
        } else if (inputString.matches("android.print\\(\\d+\\*\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\*\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\*\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\*\\d+\\)")) {

            String[] splitString = inputString.split(Pattern.quote("print"));

            String inputString2 = splitString[1];

            String[] sub = inputString2.split(Pattern.quote("*"));

            String subOne = sub[0];
            String subTwo = sub[1];

            if (subOne.contains(".")) {
                inputMatch = Pattern.compile("\\d+\\.\\d+").matcher(subOne);
                inputMatch.find();
            } else {
                inputMatch = Pattern.compile("\\d+").matcher(subOne);
                inputMatch.find();
            }

            if (subTwo.contains(".")) {
                inputMatch2 = Pattern.compile("\\d+\\.\\d+").matcher(subTwo);
                inputMatch2.find();
            } else {
                inputMatch2 = Pattern.compile("\\d+").matcher(subTwo);
                inputMatch2.find();
            }

            parse = (Double.valueOf(inputMatch.group()) * Double.valueOf(inputMatch2.group()));

            toString = parse.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));
            if (toString.matches("\\d+.0")) {
                String subString = toString.substring(0, toString.length() - 2);
                output.setText(subString);
            } else {
                output.setText(toString);
            }

        } else if (inputString.matches("android.print\\(\\d+\\/\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\/\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\/\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\/\\d+\\)")) {

            String[] splitString = inputString.split(Pattern.quote("print"));

            String inputString2 = splitString[1];

            String[] sub = inputString2.split(Pattern.quote("/"));

            String subOne = sub[0];
            String subTwo = sub[1];

            if (subOne.contains(".")) {
                inputMatch = Pattern.compile("\\d+\\.\\d+").matcher(subOne);
                inputMatch.find();
            } else {
                inputMatch = Pattern.compile("\\d+").matcher(subOne);
                inputMatch.find();
            }

            if (subTwo.contains(".")) {
                inputMatch2 = Pattern.compile("\\d+\\.\\d+").matcher(subTwo);
                inputMatch2.find();
            } else {
                inputMatch2 = Pattern.compile("\\d+").matcher(subTwo);
                inputMatch2.find();
            }

            parse = (Double.valueOf(inputMatch.group()) / Double.valueOf(inputMatch2.group()));

            toString = parse.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));

            if (toString.matches("\\d+.0")) {
                String subString = toString.substring(0, toString.length() - 2);
                output.setText(subString);
            } else {
                output.setText(toString);
            }

        } else if ((inputString.matches("android.print\\(\\d+\\+\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\+\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\+\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\+\\d+\\)"))) {

            String[] splitString = inputString.split(Pattern.quote("print"));

            String inputString2 = splitString[1];

            String[] sub = inputString2.split(Pattern.quote("+"));

            String subOne = sub[0];
            String subTwo = sub[1];

            if (subOne.contains(".")) {
                inputMatch = Pattern.compile("\\d+\\.\\d+").matcher(subOne);
                inputMatch.find();
            } else {
                inputMatch = Pattern.compile("\\d+").matcher(subOne);
                inputMatch.find();
            }

            if (subTwo.contains(".")) {
                inputMatch2 = Pattern.compile("\\d+\\.\\d+").matcher(subTwo);
                inputMatch2.find();
            } else {
                inputMatch2 = Pattern.compile("\\d+").matcher(subTwo);
                inputMatch2.find();
            }

            parse = (Double.valueOf(inputMatch.group()) + Double.valueOf(inputMatch2.group()));

            toString = parse.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));

            if (toString.matches("\\d+.0")) {
                String subString = toString.substring(0, toString.length() - 2);
                output.setText(subString);
            } else {
                output.setText(toString);
            }

        } else if ((inputString.matches("android.print\\(\\d+\\-\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\-\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\-\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\-\\d+\\)"))) {

            String[] splitString = inputString.split(Pattern.quote("print"));

            String inputString2 = splitString[1];

            String[] sub = inputString2.split(Pattern.quote("-"));

            String subOne = sub[0];
            String subTwo = sub[1];

            if (subOne.contains(".")) {
                inputMatch = Pattern.compile("\\d+\\.\\d+").matcher(subOne);
                inputMatch.find();
            } else {
                inputMatch = Pattern.compile("\\d+").matcher(subOne);
                inputMatch.find();
            }

            if (subTwo.contains(".")) {
                inputMatch2 = Pattern.compile("\\d+\\.\\d+").matcher(subTwo);
                inputMatch2.find();
            } else {
                inputMatch2 = Pattern.compile("\\d+").matcher(subTwo);
                inputMatch2.find();
            }

            parse = (Double.valueOf(inputMatch.group()) - Double.valueOf(inputMatch2.group()));

            toString = parse.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));

            if (toString.matches("\\d+.0")) {
                String subString = toString.substring(0, toString.length() - 2);
                output.setText(subString);
            } else {
                output.setText(toString);
            }

        } else if (inputString.matches("android.print\\(\\d+\\&\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\&\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\&\\d+\\.\\d+\\)") || inputString.matches("android.print\\(\\d+\\.\\d+\\&\\d+\\)")) {

            String[] splitString = inputString.split(Pattern.quote("&"));

            String inputString1 = splitString[0];

            String inputString2 = splitString[1];

            inputMatch = Pattern.compile("\\d+").matcher(inputString1);
            inputMatch.find();

            inputMatch2 = Pattern.compile("\\d+").matcher(inputString2);
            inputMatch2.find();

            Integer parseInt = (Integer.valueOf(inputMatch.group()) & Integer.valueOf(inputMatch2.group()));

            toString = parseInt.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));
            output.setText(toString);

        } else if (inputString.matches("android.print\\(\\d+\\.\\d+\\)")) {

            inputMatch = Pattern.compile("\\d+\\.\\d+").matcher(inputString);
            inputMatch.find();

            parse = (Double.parseDouble(inputMatch.group()));

            toString = parse.toString();
            output.setVisibility(View.VISIBLE);
            output.setTextColor(Color.parseColor("#000000"));

            if (toString.matches("\\d+.0")) {
                String subString = toString.substring(0, toString.length() - 2);
                output.setText(subString);
            } else {
                output.setText(toString);
            }

        } else if (inputString.matches("android.print\\(\\d+\\)")) {

            inputMatch = Pattern.compile("\\d+").matcher(inputString);
            inputMatch.find();

            Integer parseIntA = (Integer.parseInt(inputMatch.group()));

            toString = parseIntA.toString();
            output.setTextColor(Color.parseColor("#000000"));

            output.setText(toString);
            output.setVisibility(View.VISIBLE);

        } else if (inputString.matches("") || inputString.matches("\\s+")) {

            output.setVisibility(View.GONE);

        } else if (inputString.matches("android.action\\(\\[sendMail\\]\".+\"\\-\".+\"\\-\".+@.+\\..+\"\\)"))

        {

            String[] splitString = inputString.split(Pattern.quote("-"));

            String inputString1 = splitString[0];
            inputln = inputString1;
            inputln = inputln.substring(26, inputln.length() - 1);

            String input2String1 = splitString[1];
            String input2ln = input2String1;
            input2ln = input2ln.substring(1, input2ln.length() - 1);

            String input3String1 = splitString[2];
            String second = input3String1;
            second = second.substring(1, second.length() - 2);

            output.setVisibility(View.VISIBLE);
            output.setText("SEND MAIL ACTION ON " + line);
            output.setTextColor(Color.parseColor("#4CAF50"));
            Uri emailuri = Uri.parse("mailto:");
            intent = new Intent(Intent.ACTION_SENDTO, emailuri);
            intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{second});
            intent.putExtra(Intent.EXTRA_SUBJECT, inputln);
            intent.putExtra(Intent.EXTRA_TEXT, input2ln);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else if (inputString.matches("android.action\\(\\[callNumb\\]\\d+\\)"))

        {
            inputln = inputString;
            inputln = inputln.substring(25, inputString.length() - 1);
            output.setVisibility(View.VISIBLE);
            output.setText("CALL NUMB ACTION ON " + line);
            output.setTextColor(Color.parseColor("#4CAF50"));
            intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + inputln));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else if (inputString.matches("android.action\\(\\[textMssg\\]\".+\"\\-\\d+\\)"))

        {
            String[] splitString = inputString.split(Pattern.quote("-"));

            String inputString1 = splitString[0];

            inputln = inputString1;
            inputln = inputln.substring(26, inputln.length() - 1);

            String input2String2 = splitString[1];

            String second = input2String2;
            second = second.substring(0, second.length() - 1);

            output.setVisibility(View.VISIBLE);
            output.setText("TEXT MSSG ACTION ON " + line);
            output.setTextColor(Color.parseColor("#4CAF50"));
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setType("vnd.android-dir/mms-sms");
            intent.putExtra("sms_body", inputln);
            intent.putExtra("address", second);
            startActivity(intent);

        } else

        {

            if (inputString.matches("") || inputString.matches("\\s+")) {
                output.setVisibility(View.GONE);
            } else {
                output.setVisibility(View.VISIBLE);
                output.setTextColor(Color.parseColor("#D50000"));
                output.setText("COMMAND NOT RECOGNISED ON " + line);
            }
        }

    }


    /*Method-one
    Input/Output Setter & JM Functions Creator (Core)
     */
    public void runInput(View v) {

        //i/o-one
        input = (EditText) findViewById(R.id.input);
        inputString = input.getText().toString();
        output = (TextView) findViewById(R.id.output);
        core(inputln, inputMatch, inputMatch2, parse, toString, intent, input, inputString, output, "LN1");

        //i/o-2
        input2 = (EditText) findViewById(R.id.input2);
        inputString2 = input2.getText().toString();
        output2 = (TextView) findViewById(R.id.output2);
        core(inputln2, input2Match, input2Match2, parse2, toString2, intent2, input2, inputString2, output2, "LN2");

        //i/o-3
        input3 = (EditText) findViewById(R.id.input3);
        inputString3 = input3.getText().toString();
        output3 = (TextView) findViewById(R.id.output3);
        core(inputln3, input3Match, input3Match2, parse3, toString3, intent3, input3, inputString3, output3, "LN3");

        //i/o-4
        input4 = (EditText) findViewById(R.id.input4);
        inputString4 = input4.getText().toString();
        output4 = (TextView) findViewById(R.id.output4);
        core(inputln4, input4Match, input4Match2, parse4, toString4, intent4, input4, inputString4, output4, "LN4");

        //i/o-5
        input5 = (EditText) findViewById(R.id.input5);
        inputString5 = input5.getText().toString();
        output5 = (TextView) findViewById(R.id.output5);
        core(inputln5, input5Match, input5Match2, parse5, toString5, intent5, input5, inputString5, output5, "LN5");

    }

    /*Method-2
    JM Function Shortcut Creators
     */
    public void coreCreate(EditText input, String inputString) {

        this.input = input;
        this.inputString = inputString;

        rb = (RadioButton) findViewById(R.id.rb);
        boolean isChecked = rb.isChecked();
        rb2 = (RadioButton) findViewById(R.id.rb2);
        boolean isChecked2 = rb2.isChecked();

        boolean matches = inputString.matches("android.print\\(.+\\)");
        boolean matches2 = inputString.matches("android.action\\(\\[sendMail\\]\".+\"\\-\".+\"\\-\".+@.+\\..+\"\\)") ||
                inputString.matches("android.action\\(\\[callNumb\\]\\d+\\)") ||
                inputString.matches("android.action\\(\\[textMssg\\]\".+\"\\-\\d+\\)");

        if (isChecked) {
            if (matches) {
                input.append("");
                input.setHint("");
            } else {
                input.setText("android.print()");
            }

        } else if (isChecked2) {
            if (matches2) {
                input.append("");
                input.setHint("");
            } else {
                input.setText("android.action([])");
            }
        } else {
            input.setHint("No Code Selected");
            input.setText("");
        }
    }

    public void createCmd1(View v) {
        input = (EditText) findViewById(R.id.input);
        inputString = input.getText().toString();
        coreCreate(input, inputString);
    }

    public void createCmd2(View v) {
        input2 = (EditText) findViewById(R.id.input2);
        inputString2 = input2.getText().toString();
        coreCreate(input2, inputString2);
    }

    public void createCmd3(View v) {
        input3 = (EditText) findViewById(R.id.input3);
        inputString3 = input3.getText().toString();
        coreCreate(input3, inputString3);
    }

    public void createCmd4(View v) {
        input4 = (EditText) findViewById(R.id.input4);
        inputString4 = input4.getText().toString();
        coreCreate(input4, inputString4);
    }

    public void createCmd5(View v) {
        input5 = (EditText) findViewById(R.id.input5);
        inputString5 = input5.getText().toString();
        coreCreate(input5, inputString5);
    }

    public void createCmdAll(View v) {
        input = (EditText) findViewById(R.id.input);
        inputString = input.getText().toString();
        coreCreate(input, inputString);
        input2 = (EditText) findViewById(R.id.input2);
        inputString2 = input2.getText().toString();
        coreCreate(input2, inputString2);
        input3 = (EditText) findViewById(R.id.input3);
        inputString3 = input3.getText().toString();
        coreCreate(input3, inputString3);
        input4 = (EditText) findViewById(R.id.input4);
        inputString4 = input4.getText().toString();
        coreCreate(input4, inputString4);
        input5 = (EditText) findViewById(R.id.input5);
        inputString5 = input5.getText().toString();
        coreCreate(input5, inputString5);
    }


    /*Method-3
    Clear Output console
     */
    public void clearOutput(View v) {

        output = (TextView) findViewById(R.id.output);
        output2 = (TextView) findViewById(R.id.output2);
        output3 = (TextView) findViewById(R.id.output3);
        output4 = (TextView) findViewById(R.id.output4);
        output5 = (TextView) findViewById(R.id.output5);

        output.setText("");
        output2.setText("");
        output3.setText("");
        output4.setText("");
        output5.setText("");

        output.setVisibility(View.GONE);
        output2.setVisibility(View.GONE);
        output3.setVisibility(View.GONE);
        output4.setVisibility(View.GONE);
        output5.setVisibility(View.GONE);

    }


    public void clearInput(View v) {

        input = (EditText) findViewById(R.id.input);
        input.setText("");
        input.setHint("");

        input2 = (EditText) findViewById(R.id.input2);
        input2.setText("");
        input2.setHint("");

        input3 = (EditText) findViewById(R.id.input3);
        input3.setText("");
        input3.setHint("");

        input4 = (EditText) findViewById(R.id.input4);
        input4.setText("");
        input4.setHint("");

        input5 = (EditText) findViewById(R.id.input5);
        input5.setText("");
        input5.setHint("");

    }


}