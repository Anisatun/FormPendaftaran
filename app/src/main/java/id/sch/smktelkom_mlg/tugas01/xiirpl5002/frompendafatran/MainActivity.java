package id.sch.smktelkom_mlg.tugas01.xiirpl5002.frompendafatran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button button;
    RadioGroup radiogrup;
    CheckBox cb1, cb2, cb3;
    Spinner spn;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.etNama);
        button = (Button) findViewById(R.id.button);
        radiogrup = (RadioGroup) findViewById(R.id.radiogrup);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        tvhasil = (TextView) findViewById(R.id.tvhasil);
        spn = (Spinner) findViewById(R.id.spn);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {

        if (isValid()) {
            String nama = etNama.getText().toString();
            StringBuilder builder = new StringBuilder();
            String hasil = null;

            if (radiogrup.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(radiogrup.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvhasil.setText("anda belum mengisi");
            } else {
                String materi = "\t Materi yang dikuasai \t\n";
                int startlen = materi.length();
                if (cb1.isChecked()) materi += "\t\t - " + cb1.getText() + "\n";
                if (cb2.isChecked()) materi += "\t\t - " + cb2.getText() + "\n";
                if (cb3.isChecked()) materi += "\t\t - " + cb3.getText() + "\n";
                if (materi.length() == startlen) {
                    tvhasil.setText("Anda belum memilih materi");
                } else {
                    builder.append("Nama:" + nama + "\n");
                    builder.append("Jenis kelamin : " + hasil + "\n");
                    builder.append(materi + "\n");
                    builder.append("Provinsi:");
                    builder.append(spn.getSelectedItem().toString() + "\n");
                    tvhasil.setText(builder);
                }
            }

        }


    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
