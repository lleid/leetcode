####centos
```
yum -y install pcre-devel
yum install -y zlib-devel

./configure
make && make install

/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf
```

***
[下载地址](http://nginx.org/en/download.html)