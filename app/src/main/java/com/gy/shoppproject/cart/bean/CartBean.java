package com.gy.shoppproject.cart.bean;

import java.util.List;

public
class CartBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":1911,"user_id":0,"session_id":"1","goods_id":1134032,"goods_sn":"1134032","product_id":199,"goods_name":"趣味粉彩系列记忆棉坐垫","market_price":49,"retail_price":49,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png"},{"id":1912,"user_id":0,"session_id":"1","goods_id":1006013,"goods_sn":"1006013","product_id":10,"goods_name":"双宫茧桑蚕丝被 空调被","market_price":699,"retail_price":699,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png"},{"id":1919,"user_id":0,"session_id":"1","goods_id":1097014,"goods_sn":"1097014","product_id":128,"goods_name":"原素系列实木多抽柜","market_price":4199,"retail_price":4199,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/308184b7b1965470d58b5c92e9bcc4b0.png"}],"cartTotal":{"goodsCount":11,"goodsAmount":19739,"checkedGoodsCount":4,"checkedGoodsAmount":16796}}
     */
    private Integer number;
    private Integer errno;
    private String errmsg;
    private DataBean data;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cartList : [{"id":1911,"user_id":0,"session_id":"1","goods_id":1134032,"goods_sn":"1134032","product_id":199,"goods_name":"趣味粉彩系列记忆棉坐垫","market_price":49,"retail_price":49,"number":3,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png"},{"id":1912,"user_id":0,"session_id":"1","goods_id":1006013,"goods_sn":"1006013","product_id":10,"goods_name":"双宫茧桑蚕丝被 空调被","market_price":699,"retail_price":699,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png"},{"id":1919,"user_id":0,"session_id":"1","goods_id":1097014,"goods_sn":"1097014","product_id":128,"goods_name":"原素系列实木多抽柜","market_price":4199,"retail_price":4199,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/308184b7b1965470d58b5c92e9bcc4b0.png"}]
         * cartTotal : {"goodsCount":11,"goodsAmount":19739,"checkedGoodsCount":4,"checkedGoodsAmount":16796}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 11
             * goodsAmount : 19739
             * checkedGoodsCount : 4
             * checkedGoodsAmount : 16796
             */

            private Integer goodsCount;
            private Integer goodsAmount;
            private Integer checkedGoodsCount;
            private Integer checkedGoodsAmount;

            public Integer getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(Integer goodsCount) {
                this.goodsCount = goodsCount;
            }

            public Integer getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(Integer goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public Integer getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(Integer checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public Integer getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(Integer checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 1911
             * user_id : 0
             * session_id : 1
             * goods_id : 1134032
             * goods_sn : 1134032
             * product_id : 199
             * goods_name : 趣味粉彩系列记忆棉坐垫
             * market_price : 49
             * retail_price : 49
             * number : 3
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 0
             * list_pic_url : http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png
             */
            boolean isChecked = false;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }
            private Integer id;
            private Integer user_id;
            private String session_id;
            private Integer goods_id;
            private String goods_sn;
            private Integer product_id;
            private String goods_name;
            private double market_price;
            private double retail_price;
            private Integer number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private Integer checked;
            private String list_pic_url;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUser_id() {
                return user_id;
            }

            public void setUser_id(Integer user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public Integer getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(Integer goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public Integer getProduct_id() {
                return product_id;
            }

            public void setProduct_id(Integer product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public double getMarket_price() {
                return market_price;
            }

            public void setMarket_price(double market_price) {
                this.market_price = market_price;
            }

            public double getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(double retail_price) {
                this.retail_price = retail_price;
            }

            public Integer getNumber() {
                return number;
            }

            public void setNumber(Integer number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public Integer getChecked() {
                return checked;
            }

            public void setChecked(Integer checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }
        }
    }
}
