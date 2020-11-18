/*安全课程加密程序V1.0
 *作者：yangyc
 */
//引入头文件用
#include <stdio.h>
//字符串 提供了一些字符串所要用到的函数
#include <string.h>
//系统函数
#include <stdlib.h>
#include <ctype.h>

/*声明一些的变量*/
char ch = '0';
char filename[256] = "";//保存输入的数据 文件的路径
FILE *fp = NULL;//定义宏 初始化为NULL 指针
FILE *fptemp = NULL;
const char tempfile[256] = "temp1234567890.temp";
char password[12] = "123456";
int pwdlen = 0;//密码长度
int i = 0;

 /*函数声明*/
void menu();
void inputpass(char *pass);

/*函数实现*/
void inputpass(char *pass)
{
    /*阻塞等待输入*/
    scanf("%s", pass);
}


void menu()
{
    printf("******************************************************\n");
    printf("************************安全课程小程序*****************\n");
    printf("******************************************************\n");
    printf("**请输入要加密或解密的文件的路径**\n");
    printf("**例如：/user/liang/av.txt**\n");
    /*步骤一：要打开一个文件或目录*/
    /*通过字符终端读取一个字符串*/
    gets(filename); 
    
    if( NULL == ( fp = fopen(filename, "rb") ) )
    {
        /*如果不为空 表示文件存在，空的 表示文件不存在*/
        printf("您好！你所输入的文件不存在\n");
        /*退出*/
        exit(1);
    }
    /*如果文件存在*/
    printf("文件存在，请输入密码。如：888888888888\n");
    /*输入密码*/
    inputpass(password);
    pwdlen = (int)strlen(password);
    if( 0 == pwdlen )
    {
        printf("对不起！ 密码长度不能为0.\n");
        exit(2);
    }

    /*步骤二：读出内容进行加密*/
    fptemp = fopen(tempfile, "wb");


    /*步骤三：把加密的信息写入到文件中覆盖原来的数据*/
    while(1)
    {
        ch = getc(fp);
        if( feof(fp) )
        {
            /*判断文件是否读完*/
            break;
        }
        /*每取出除一个字符就加密*/
        //异或混淆
        ch^=password[i++];
        //ch里就是加密以后的数据
        fputc(ch, fptemp);
        //判断
        if( i == pwdlen )
        {
            i = 0;
        }
    }
    //循环结束后
    fclose(fp);
    fclose(fptemp);
    remove(filename);
    rename(tempfile, filename);
    printf("恭喜你！加密或解密成功。。。");
}



//主函数 是C语言程序的入口地址
int main(int argc, char const *argv[])
{
    /* 函数调用 */
    menu();
    return 0;

}