package com.springmvc.cache;

import com.springmvc.pojo.UserInfo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息缓存
 */
public class LoginUserCache {
    private static Map<Long,LoginUser> cache = new HashMap<Long, LoginUser>();

    //获取用户信息
//    private static UserInfo get(){
//
//    }
    /**
     *保存信息
     * @param userInfo
     * @param expire 单位秒，如果是30分钟过期，即：60*30=1800
     */
    public static void put(UserInfo userInfo,long expire){
        //当前时间往后延迟30分钟，即需要的超时时间               getTime()毫秒，*1000即为分钟
        long expireTime = Calendar.getInstance().getTime().getTime()+expire * 1000;
        LoginUser loginUser = new LoginUser();
        loginUser.setUserInfo(userInfo);
        loginUser.setExpire(expireTime);
        cache.put(userInfo.getUserId(),loginUser);
    }

    private static class LoginUser{
        private long expire;
        private UserInfo userInfo;

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }
    }
}
