
####用户

```
whoami
cat /etc/passwd
cat /etc/group
useradd -d /usr/sft -m sft
passwd sft

usermod -l NewUser -d /home/NewUser -m OldUser
groupmod -n NewUser OldName
```

####文件命令

```
cp -r oldPath newPath
mv olaName newName
```


####进程

```
netstat –apn | grep 8080
ps -aux | grep pid 
kill -9 进程号
```

####权限

```
chattr -i .user.ini 
chmod +xx *.sh 
```

####ssh

```
禁止root登录和要制定用户登录
cat /etc/ssh/sshd_config
=> AllowUsers sftm ycyp
=> PermitRootLogin no

service sshd restart
```

####JAVA_HOME

```
export JAVA_HOME=/usr/java/jdk1.6.0_14
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/rt.jar:$CLASSPATH
```

####压缩和解压

```
tar -zcvf wordpress.tar.gz wordpress
tar -zxvf file.tar.gz
unzip -o -d /home/test test.zip
```

####Mysql

```
mysqldump -u 用户名 -p 数据库名 > 导出的文件名
```
####开机启动

```
1./etc/rc.local 中添加*.sh
2./etc/init.d/脚本
  chkconfig --list
  chkconfig --add 脚本
  chkconfig --level  级别<3> 脚本 on
```

####磁盘
```
df -lh  --查看磁盘空间
du -h --max-depth=1 /home  --home下个文件大小
```

####定时器

```
crontab定时器：yum install -y vixie-cron
```
