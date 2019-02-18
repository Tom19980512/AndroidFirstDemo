package com.tzg.endgraduationwork.Activity;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tzg.endgraduationwork.BaseActivity;
import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;
import com.tzg.endgraduationwork.MyAdapter.PYAdapter;
import com.tzg.endgraduationwork.R;
import com.tzg.endgraduationwork.XiangQinActivity.PyXiangJie;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public class PyActivity extends BaseActivity {
    private EditText editText;
    private ImageView btn_ser;
    private RecyclerView myrec;

    private List<PYJiGuoBean.ResultBean.ListBean> pyDate = new ArrayList<PYJiGuoBean.ResultBean.ListBean>();
    private PYAdapter pyAdapter;

    private String MyKey = "bf1f9352094074c284aa3a2caad67b73";
    private String Old_word = "";
    private int page = 1;
    private String[] str = {"a","ai","an","ang","ao","ba","bai","ban","bang","bao","bei","ben","beng","bi","bian","biao","bie","bin","bing","bo","bu","ca","cai","can","cang","cao","ce","cen","ceng","cha","chai","chan","chang","chao","che","chen","cheng","chi","chong","chou","chu","chua","chuai","chuan","chuang","chui","chun","chuo","ci","cong","cou","cu","cuan","cui","cun","cuo","da","dai","dan","dang","dao","de","den","dei","deng","di","dia","dian","diao","die","ding","diu","dong","dou","du","duan","dui","dun","duo","e","ei","en","eng","er","fa","fan","fang","fei","fen","feng","fo","fou","fu","ga","gai","gan","gang","gao","ge","gei","gen","geng","gong","gou","gu","gua","guai","guan","guang","gui","gun","guo","ha","hai","han","hang","hao","he","hei","hen","heng","hong","hou","hu","hua","huai","huan","huang","hui","hun","huo","ji","jia","jian","jiang","jiao","jie","jin","jing","jiong","jiu","ju","juan","jue","jun","ka","kai","kan","kang","kao","ke","ken","keng","kong","kou","ku","kua","kuai","kuan","kuang","kui","kun","kuo","la","lai","lan","lang","lao","le","lei","leng","li","lia","lian","liang","liao","lie","lin","ling","liu","long","lou","lu","lv","luan","lue","lve","lun","luo","ma","mai","man","mang","mao","me","mei","men","meng","mi","min","ming","mian","miao","mie","miu","mo","mou","mu","na","nai","nan","nang","nao","ne","nei","nen","neng","ni","nian","niang","niao","nie","nin","ning","niu","nong","nou","nu","nv","nuan","nve","nuo","nun","o","ou","pa","pai","pan","pang","pao","pei","pen","peng","pi","pian","piao","pie","pin","ping","po","pou","pu","qi","qia","qian","qiang","qiao","qie","qin","qing","qiong","qiu","qu","quan","que","qun","ran","rang","rao","re","ren","reng","ri","rong","rou","ru","ruan","rui","run","ruo","sa","sai","san","sang","sao","se","sen","seng","sha","shai","shan","shang","shao","she","shei","shen","sheng","shi","shou","shu","shua","shuai","shuan","shuang","shui","shun","shuo","si","song","sou","su","suan","sui","sun","suo","ta","tai","tan","tang","tao","te","teng","ti","tian","tiao","tie","ting","tong","tou","tu","tuan","tui","tun","tuan","tui","tun","tuo","wa","wai","wan","wang","wei","wen","weng","wo","wu","xi","xia","xian","xiang","xiao","xie","xin","xing","xiong","xiu","xu","xuan","xue","xun","ya","yan","yang","yao","ye","yi","yin","ying","yo","yong","you","yu","yuan","yue","yun","za","zan","zang","zao","ze","zei","zen","zeng","zha","zhai","zhan","zhang","zhao","zhe","zhei","zhen","zheng","zhi","zhong","zhou","zhu","zhua","zhuai","zhuan","zhuang","zhui","zhun","zhuo","zi","zong","zou","zu","zuan","zui","zun","zuo"};

    @Override
    public void btnSerListener() {
        getSupportActionBar().hide();//隐藏标题栏
        initFindById();
        btn_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!editText.getText().toString().trim().equals("")&&rexStr(str,editText.getText().toString().trim())){
                    if (pyDate.size()==0){
                        NewWoke();
                    }
                    if (pyDate.size()>0){
                        if(!editText.getText().toString().trim().equals(Old_word)&&!editText.getText().toString().trim().equals("")){
                            pyDate.clear();//清除上一次搜索的数据
                            pyAdapter.setMadapterlist(pyDate);//将清除后的List返回到适配器  清空上一次的搜索结果
                            NewWoke();
                        }else{
                            Toast.makeText(PyActivity.this,"您输入与上次输入相同",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(PyActivity.this,"您输入的为空或输入有误",Toast.LENGTH_SHORT).show();
                }
            }
        });

        myrec.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case SCROLL_STATE_IDLE:
                        Log.e("onscroll","当前并不处于滑动状态");
                        break;
                    case SCROLL_STATE_DRAGGING:
                        page = page+1;
                        Log.e("page_py","页数"+page);
                        addListBean(page);
                        Log.e("onscroll","当前RecyclerView处于滑动状态(手指在屏幕上)");
                        break;
                    case SCROLL_STATE_SETTLING:
                        pyAdapter.setMadapterlist(pyDate);
                        Log.e("onscroll","当前RecyclerView处于滑动状态(手已经离开屏幕)");
                        break;
                }
            }
        });
    }

    public void initUIRefor() {
        myrec.setLayoutManager(new LinearLayoutManager(this));
        pyAdapter = new PYAdapter();
        pyAdapter.setOnItem(new PYAdapter.OnItem() {
            @Override
            public void onItemClick(int position) {
                Log.e("onclike","点击第"+(position+1)+"条");
                Intent intent = new Intent(PyActivity.this,PyXiangJie.class);
                intent.putExtra("py",pyDate.get(position));
                startActivity(intent);
            }
        });
        myrec.setAdapter(pyAdapter);
    }

    @Override
    public int getLayoutinto() {
        return R.layout.activity_py;
    }

    public void initFindById(){
        editText = (EditText) findViewById(R.id.ed_py);
        btn_ser = (ImageView) findViewById(R.id.ser_py);
        myrec = (RecyclerView) findViewById(R.id.recy);
    }
    //发送请求并返回到适配器
    public void NewWoke(){
        Old_word = editText.getText().toString().trim();
        netWork.getJieGuopy(MyKey,Old_word,page,1,1)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<PYJiGuoBean, List<PYJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public List<PYJiGuoBean.ResultBean.ListBean> call(PYJiGuoBean pyJiGuoBean) {
                        return pyJiGuoBean.getResult().getList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PYJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<PYJiGuoBean.ResultBean.ListBean> listBeans) {
                        Toast.makeText(PyActivity.this,"正在查询",Toast.LENGTH_SHORT).show();
                        pyDate.addAll(listBeans);
                        pyAdapter.setMadapterlist(pyDate);
                        Log.e("listsize","数据条目"+listBeans.size());
                    }
                });
    }
    //发送请求
    public void addListBean(int page){
        netWork.getJieGuopy(MyKey,Old_word,page,1,1)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<PYJiGuoBean, List<PYJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public List<PYJiGuoBean.ResultBean.ListBean> call(PYJiGuoBean pyJiGuoBean) {
                        return pyJiGuoBean.getResult().getList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PYJiGuoBean.ResultBean.ListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<PYJiGuoBean.ResultBean.ListBean> listBeans) {
                        Log.e("addListBean","正在调用addListBean进行查询");
                        pyDate.addAll(listBeans);
                        Log.e("addListBean","数据条目"+listBeans.size());
                    }
                });
    }
    //字符串匹配规则
    public boolean rexStr(String[] a,String str){
        for(int i = 0;i<a.length;i++){
            if(a[i].equals(str)){
                return true;
            }
        }
        return false;
    }
}
