package com.tzg.endgraduationwork.DataBean;

import java.io.Serializable;
import java.util.List;

public class JiGuoBean {

    /**
     * reason : 返回成功
     * result : {"id":"a00c13b3dd792c3e","zi":"谭","py":"tan","wubi":"ysjh","pinyin":"tán","bushou":"讠","bihua":"14","jijie":["谭","（譚）","tán","同\u201c谈\u201d。","姓。","","笔画数：14；","部首：讠；","笔顺编号：45125221251112"],"xiangjie":["谭","譚","tán","【动】","(形声。从言,覃声。本义:同\u201c谈\u201d,说)","同本义〖talk〗","夫子何不谭我于王。\u2014\u2014《庄子·则阳》","又如:谭笑(谈笑);谭艺(谈论文学艺术);谭说(议论;谈论);谭吐(说话时的措词和态度);谭助(谈资);谭言微中(说话隐微曲折而切中事理)","绵延相及〖haveaneffecton〗","不称而祀谭,次祖。犯诅渝盟,伤言。\u2014\u2014《管子》","","谭","譚","tán","【形】","宏大,广大〖big〗","富恭有本能图,修业居久而谭。\u2014\u2014《大戴礼记》。王聘珍解诂:\u201c《广韵》:\u2018谭,大也。\u2019业安于久而自大也。\u201d","谭","譚","tán","【名】","同\u201c谈\u201d。言论〖opiniononpublicaffairs;viewsonpolitics〗","此老生之常谭。\u2014\u2014陈寿《三国志》","古代国名〖Tanstate〗。在今山东省济南市东龙山镇附近。公元前684年为齐所灭","姓","另见xún"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean implements Serializable {
        /**
         * id : a00c13b3dd792c3e
         * zi : 谭
         * py : tan
         * wubi : ysjh
         * pinyin : tán
         * bushou : 讠
         * bihua : 14
         * jijie : ["谭","（譚）","tán","同\u201c谈\u201d。","姓。","","笔画数：14；","部首：讠；","笔顺编号：45125221251112"]
         * xiangjie : ["谭","譚","tán","【动】","(形声。从言,覃声。本义:同\u201c谈\u201d,说)","同本义〖talk〗","夫子何不谭我于王。\u2014\u2014《庄子·则阳》","又如:谭笑(谈笑);谭艺(谈论文学艺术);谭说(议论;谈论);谭吐(说话时的措词和态度);谭助(谈资);谭言微中(说话隐微曲折而切中事理)","绵延相及〖haveaneffecton〗","不称而祀谭,次祖。犯诅渝盟,伤言。\u2014\u2014《管子》","","谭","譚","tán","【形】","宏大,广大〖big〗","富恭有本能图,修业居久而谭。\u2014\u2014《大戴礼记》。王聘珍解诂:\u201c《广韵》:\u2018谭,大也。\u2019业安于久而自大也。\u201d","谭","譚","tán","【名】","同\u201c谈\u201d。言论〖opiniononpublicaffairs;viewsonpolitics〗","此老生之常谭。\u2014\u2014陈寿《三国志》","古代国名〖Tanstate〗。在今山东省济南市东龙山镇附近。公元前684年为齐所灭","姓","另见xún"]
         */

        private String id;
        private String zi;
        private String py;
        private String wubi;
        private String pinyin;
        private String bushou;
        private String bihua;
        private List<String> jijie;
        private List<String> xiangjie;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getZi() {
            return zi;
        }

        public void setZi(String zi) {
            this.zi = zi;
        }

        public String getPy() {
            return py;
        }

        public void setPy(String py) {
            this.py = py;
        }

        public String getWubi() {
            return wubi;
        }

        public void setWubi(String wubi) {
            this.wubi = wubi;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getBihua() {
            return bihua;
        }

        public void setBihua(String bihua) {
            this.bihua = bihua;
        }

        public List<String> getJijie() {
            return jijie;
        }

        public void setJijie(List<String> jijie) {
            this.jijie = jijie;
        }

        public List<String> getXiangjie() {
            return xiangjie;
        }

        public void setXiangjie(List<String> xiangjie) {
            this.xiangjie = xiangjie;
        }
    }
}
