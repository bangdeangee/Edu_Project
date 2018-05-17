package com.jyp.jyp_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UnderSubActivity1 extends AppCompatActivity {
    ArrayList<Contents> itemsA = new ArrayList<Contents>();
    ArrayList<Contents> itemsB = new ArrayList<Contents>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_sub1);

        Button lowButton = (Button) findViewById(R.id.lowButton);
        Button highButton = (Button) findViewById(R.id.highButton);

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               String[] itemsA = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "III"};
//                ListAdapter adapterA = new ArrayAdapter<String>(UnderSubActivity1.this, android.R.layout.simple_list_item_1, itemsA); //안드로이드에서 제공하는 레이아웃인 simple_list_item_1화면을 사용하여 itemsA 데이터를 사용.

                itemsA.add(new Contents("AAA",readTxtA(),effectA()));
                itemsA.add(new Contents("BBB",readTxtB(),effectB()));
                itemsA.add(new Contents("CCC",readTxtC(),effectC()));
                itemsA.add(new Contents("DDD",readTxtD(),effectD()));
                itemsA.add(new Contents("EEE",readTxtE(),effectE()));
                itemsA.add(new Contents("FFF",readTxtF(),effectF()));
                itemsA.add(new Contents("GGG",readTxtG(),effectG()));
                itemsA.add(new Contents("HHH",readTxtH(),effectH()));
                itemsA.add(new Contents("III",readTxtI(),effectI()));
                itemsA.add(new Contents("JJJ",readTxtJ(),effectJ()));

//                ListView listViewA = (ListView) findViewById(R.id.listview);
//                listViewA.setAdapter(adapterA);

                MyAdapterA adapterA = new MyAdapterA(
                        getApplicationContext(), // 현재화면의 제어권자
                        R.layout.listview_helper_a,  // 리스트뷰의 한행의 레이아웃
                        itemsA);        // 데이터

                ListView listViewA = (ListView)findViewById(R.id.listview);
                listViewA.setAdapter(adapterA);

                // listview A의 내용 클릭때 발생 이벤트 처리(확인용)
//                listViewA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        String item = String.valueOf(adapterView.getItemAtPosition(i));
//                        Toast.makeText(UnderSubActivity1.this, item, Toast.LENGTH_SHORT).show();
//
//                    }
//                });
                // listview A Item 클릭 때 엑티비티 전환
                listViewA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                // 상세정보 화면으로 이동하기(인텐트 날리기)
                                // 1. 다음화면을 만든다
                                // 2. AndroidManifest.xml 에 화면을 등록한다
                                // 3. Intent 객체를 생성하여 날린다
                                Intent intent = new Intent(
                                        getApplicationContext(), // 현재화면의 제어권자
                                        FinalActivity1.class); // 다음넘어갈 화면

                                // intent 객체에 데이터를 실어서 보내기
                                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                                intent.putExtra("title", itemsA.get(i).title);
                                intent.putExtra("rule", itemsA.get(i).rule);
                                intent.putExtra("effect", itemsA.get(i).effect);
                                startActivity(intent);

//                                Intent undersubAIntent = new Intent(UnderSubActivity1.this, FinalActivity1.class); //Intent 날리기
//                                //intent.put메소드를 활용하여 리스트 Item별 내용 적용을 다르게 한다.(UI이 하나에서): Intent.put메소드는 안보이는 서버같은 개념인가?
//                                //undersub1Intent.putExtra("title", itemsA.get(i).title );
//                                UnderSubActivity1.this.startActivity(undersubAIntent);

                    }
                });
            }
        });


        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String[] itemsB = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii"};
//                ListAdapter adapterB = new ArrayAdapter<String>(UnderSubActivity1.this, android.R.layout.simple_list_item_1, itemsB); //안드로이드에서 제공하는 레이아웃인 simple_list_item_2화면을 사용하여 itemsB 데이터를 사용.

                itemsB.add(new Contents("aaa",readTxta(),effecta()));
                itemsB.add(new Contents("bbb",readTxtb(),effectb()));
                itemsB.add(new Contents("ccc",readTxtc(),effectc()));
                itemsB.add(new Contents("ddd",readTxtd(),effectd()));
                itemsB.add(new Contents("eee",readTxte(),effecte()));
                itemsB.add(new Contents("fff",readTxtf(),effectf()));
                itemsB.add(new Contents("ggg",readTxtg(),effectg()));
                itemsB.add(new Contents("hhh",readTxth(),effecth()));
                itemsB.add(new Contents("iii",readTxti(),effecti()));
                itemsB.add(new Contents("jjj",readTxtj(),effectj()));

//                ListView listViewB = (ListView) findViewById(R.id.listview);
//                listViewB.setAdapter(adapterB);

                MyAdapterB adapterB = new MyAdapterB(
                        getApplicationContext(), // 현재화면의 제어권자
                        R.layout.listview_helper_b,  // 리스트뷰의 한행의 레이아웃
                        itemsB);        // 데이터

                ListView listViewB = (ListView)findViewById(R.id.listview);
                listViewB.setAdapter(adapterB);


                // listview B의 내용 클릭때 발생 이벤트 처리(확인용)
//                listViewB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        String item = String.valueOf(adapterView.getItemAtPosition(i));
//                        Toast.makeText(UnderSubActivity1.this, item, Toast.LENGTH_SHORT).show();
//
//                    }
//                });
                // listview B Item 클릭 때 엑티비티 전환
                listViewB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        // 상세정보 화면으로 이동하기(인텐트 날리기)
                        // 1. 다음화면을 만든다
                        // 2. AndroidManifest.xml 에 화면을 등록한다
                        // 3. Intent 객체를 생성하여 날린다
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재화면의 제어권자
                                FinalActivity1.class); // 다음넘어갈 화면

                        // intent 객체에 데이터를 실어서 보내기
                        // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                        intent.putExtra("title", itemsB.get(i).title);
                        intent.putExtra("rule", itemsB.get(i).rule);
                        intent.putExtra("effect", itemsB.get(i).effect);

                        startActivity(intent);

//                        Intent undersubBIntent = new Intent(UnderSubActivity1.this, FinalActivity1.class); //Intent 날리기
//                        //intent.put메소드를 활용하여 리스트 Item별 내용 적용을 다르게 한다.(UI이 하나에서): Intent.put메소드는 안보이는 서버같은 개념인가?
//                        //undersub1Intent.putExtra("title", itemsA.get(i).title );
//                        UnderSubActivity1.this.startActivity(undersubBIntent);

                    }
                });

            }
        });
    }

//////////////////////////////////////////////////////////////////////////// 파일 데이터 가져오기!!!
    // TextA 데이터 출력: 저학년 놀이 방법
    private String readTxtA() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_a);
//        InputStream inputStreamB = getResources().openRawResource(R.raw.textfile_B);
//        InputStream inputStreamC = getResources().openRawResource(R.raw.textfile_C);
//        InputStream inputStreamD = getResources().openRawResource(R.raw.textfile_D);
//        InputStream inputStreamE = getResources().openRawResource(R.raw.textfile_E);
//        InputStream inputStreamF = getResources().openRawResource(R.raw.textfile_F);
//        InputStream inputStreamG = getResources().openRawResource(R.raw.textfile_G);
//        InputStream inputStreamH = getResources().openRawResource(R.raw.textfile_H);
//        InputStream inputStreamI = getResources().openRawResource(R.raw.textfile_I);
//        InputStream inputStreamJ = getResources().openRawResource(R.raw.textfile_J);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextB 데이터 출력
    private String readTxtB() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_b);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextC 데이터 출력
    private String readTxtC() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_c);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextD 데이터 출력
    private String readTxtD() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_d);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextE 데이터 출력
    private String readTxtE() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_e);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextF 데이터 출력
    private String readTxtF() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextG 데이터 출력
    private String readTxtG() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_g);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextH 데이터 출력
    private String readTxtH() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_h);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextI 데이터 출력
    private String readTxtI() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // TextJ 데이터 출력
    private String readTxtJ() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_j);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    // Texta 데이터 출력: 고학년 놀이 방법
    private String readTxta() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_aa);
//        InputStream inputStreamB = getResources().openRawResource(R.raw.textfile_B);
//        InputStream inputStreamC = getResources().openRawResource(R.raw.textfile_C);
//        InputStream inputStreamD = getResources().openRawResource(R.raw.textfile_D);
//        InputStream inputStreamE = getResources().openRawResource(R.raw.textfile_E);
//        InputStream inputStreamF = getResources().openRawResource(R.raw.textfile_F);
//        InputStream inputStreamG = getResources().openRawResource(R.raw.textfile_G);
//        InputStream inputStreamH = getResources().openRawResource(R.raw.textfile_H);
//        InputStream inputStreamI = getResources().openRawResource(R.raw.textfile_I);
//        InputStream inputStreamJ = getResources().openRawResource(R.raw.textfile_J);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textb 데이터 출력
    private String readTxtb() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_bb);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textc 데이터 출력
    private String readTxtc() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_cc);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textd 데이터 출력
    private String readTxtd() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_dd);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Texte 데이터 출력
    private String readTxte() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_ee);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textf 데이터 출력
    private String readTxtf() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_ff);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textg 데이터 출력
    private String readTxtg() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_gg);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Texth 데이터 출력
    private String readTxth() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_hh);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Texti 데이터 출력
    private String readTxti() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_ii);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // Textj 데이터 출력
    private String readTxtj() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.textfile_jj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    // effectA 데이터 출력: 저학년 효과
    private String effectA() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_a);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectB 데이터 출력
    private String effectB() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_b);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectC 데이터 출력
    private String effectC() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_c);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectD 데이터 출력
    private String effectD() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_d);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectE 데이터 출력
    private String effectE() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_e);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectF 데이터 출력
    private String effectF() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectG 데이터 출력
    private String effectG() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_g);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectH 데이터 출력
    private String effectH() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_h);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectI 데이터 출력
    private String effectI() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectJ 데이터 출력
    private String effectJ() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_j);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
// effecta 데이터 출력: 고학년 효과
private String effecta() {
    String data = null;
    InputStream inputStream = getResources().openRawResource(R.raw.effect_aa);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    int i;
    try {
        i = inputStream.read();
        while (i != -1) {
            byteArrayOutputStream.write(i);
            i = inputStream.read();
        }

        data = new String(byteArrayOutputStream.toByteArray(),"MS949");
        inputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return data;
}
    // effectb 데이터 출력
    private String effectb() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_bb);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectc 데이터 출력
    private String effectc() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_cc);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectd 데이터 출력
    private String effectd() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_dd);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effecte 데이터 출력
    private String effecte() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_ee);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectf 데이터 출력
    private String effectf() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_ff);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectg 데이터 출력
    private String effectg() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_gg);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effecth 데이터 출력
    private String effecth() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_hh);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effecti 데이터 출력
    private String effecti() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_ii);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    // effectj 데이터 출력
    private String effectj() {
        String data = null;
        InputStream inputStream = getResources().openRawResource(R.raw.effect_jj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

//AdapterA
class MyAdapterA extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Contents> itemsA;
    LayoutInflater inf;
    public MyAdapterA(Context context, int layout, ArrayList<Contents> itemsA) {
        this.context = context;
        this.layout = layout;
        this.itemsA = itemsA;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return itemsA.size();
    }
    @Override
    public Object getItem(int position) {
        return itemsA.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        //이게 어디 꺼지?
//        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView helper = (TextView)convertView.findViewById(R.id.helper_a);
//        TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

        Contents name = itemsA.get(position);
//        iv.setImageResource(m.img);
        helper.setText(name.title);
//        tvInfo.setText(m.artist);

        return convertView;
    }
}

//AdapterB
class MyAdapterB extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Contents> itemsB;
    LayoutInflater inf;
    public MyAdapterB(Context context, int layout, ArrayList<Contents> itemsB) {
        this.context = context;
        this.layout = layout;
        this.itemsB = itemsB;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return itemsB.size();
    }
    @Override
    public Object getItem(int position) {
        return itemsB.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        //이게 어디 꺼지?
//        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView helper = (TextView)convertView.findViewById(R.id.helper_b);
//        TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

        Contents name = itemsB.get(position);
//        iv.setImageResource(m.img);
        helper.setText(name.title);
//        tvInfo.setText(m.artist);

        return convertView;
    }
}

class Contents { // 체육활동별
    String title = ""; // 체육활동 title
    String rule = ""; //체육활동 방법
    String effect = ""; //체육활동 효과

    public Contents(String title, String rule, String effect) {
        super();
        this.title = title;
        this.rule = rule;
        this.effect = effect;
    }
    public Contents() {}
}


// finalActivity1로 넘기고 싶은 데이터가 있다면 위의 클래스를 이용해서(유사하게) 전달하는 방식으로 동작.
//데이터는 텍스트 파일로 만들어 raw폴더에 넣은 뒤 가공하는 방식을 취하자.