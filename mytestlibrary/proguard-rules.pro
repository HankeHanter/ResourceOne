# To enable ProGuard in your project, edit project.properties
# to define the proguard.config property as described in that file.
#
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-optimizationpasses 5		#表示proguard对你的代码进行迭代优化的次数，一般情况下迭代10次左右的时候代码已经不能再次优化了
#dontoptimize 不优化
-dontusemixedcaseclassnames         #不使用大小写混合类名
-dontskipnonpubliclibraryclasses    #指定不去忽略非公共的库类。(意思就是不忽略private libraries，也就是得在意第三方jar包)
-dontpreverify                      #混淆时不做预校验 ，预检验对Android没有卵用，这是针对J2ME以及Java 6的
-verbose                            # 混淆时记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*        # 混淆时所采用的算法
-allowaccessmodification    #优化时允许访问并修改有修饰符的类和类的成员
-keepattributes *Annotation*,Exceptions,InnerClasses,Signature,Deprecated,EnclosingMethod  #保护注解，内部类，反射，类型转换错误，废弃属性
-dontshrink		# 不压缩输入的类文件
#-adaptresourcefilenames **/*.properties,**/*.gif,**/*.dtd 			#如果资源文件与某类名同，那么混淆后资源文件被命名为与之对应的类的混淆名。不加file_filter的情况下，所有资源文件都受此影响；加了file_filter的情况下，只有匹配到的类受此影响。
#-adaptresourcefilecontents [file_filter] 			#指定资源文件的中的类名随混淆后的名字更新。根据被混淆的名字的前后映射关系，更新文件中对应的包名和类名。同样，如果不配置file_filter，所有的资源文件都会受此影响；配置了filter之后，只有对应的资源文件才受此影响。
-dontwarn android.support.v4.*				#所有jar包都得不警告
-dontwarn org.apache.**	#缺省proguard 会检查每一个引用是否正确，但是第三方库里面往往有些不会用到的类，没有正确引用。如果不配置的话，系统就会报错。
-dontwarn javax.**
-dontwarn android.os.**


#别忘了第三方jar包也要让它们不warn
#-dontwarn android.newland.**

#系统类
-keep class android.support.v4.** { *; }        # 保持哪些类不被混淆
-keep class android.os.**{*;}
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v4.app.Fragment
-keep class com.zftpay.paybox.activity.BaseActivity {*;}
-keep class com.zftpay.paybox.activity.BaseFragment {*;}
-keep public class * extends com.zftpay.paybox.activity.BaseActivity
-keep public class * extends com.zftpay.paybox.activity.BaseFragment

#官方建议不混淆
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class com.android.vending.licensing.ILicensingService

#下面别忘了keep library不被混淆以及提示library

#接下来就是方法了
#-keepclasseswithmembers {class_specification}    保护指定的类和类的成员，但条件是所有指定的类和类成员是要存在。
#-keepclasseswithmembernames {class_specification}    保护指定的类和类的成员的名称，如果所有指定的类成员出席（在压缩步骤之后）

-keepclasseswithmembernames class * {       # 保持 native 方法不被混淆
    native <methods>;
}
#keep：防止被移除或者被重命名  keepnames：防止被重命名
#如果只声明保护一个类，并没有指定受保护的成员。
#proguard只会保护它的类名和它的无参构造函数。其它成员依旧会被压缩、优化、混淆。
#如果声明保护一个方法，proguard会把它当作程序的入口点，方法名不会变，但它里面的代码依旧会被优化、混淆。

-keepclasseswithmembers class * {            # 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {		# 保持自定义控件类不被混淆
  public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {		#保持类成员
  public void *(android.view.View);
}

-keepclassmembers enum * {                  # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {    # 保持 Parcelable 不被混淆
  public static final android.os.Parcelable$Creator *;
}

#keep library不被混淆以及提示library，例如
#-libraryjars libs/cardio.jar

#keep library 里面的类不被混淆
#-keep class com.newland.** {*;}

-dontwarn com.example.oneactivity.**
-libraryjars libs/shut-up.jar
-keep class com.example.oneactivity.**{*;}

-libraryjars 'C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar'
-libraryjars 'D:\Android\AS_SDK\platforms\android-23\android.jar'

#注意：so文件不用混淆
-keep class com.example.mytestlibrary.IntentUtils {

public <fields>;

public <methods>;

}