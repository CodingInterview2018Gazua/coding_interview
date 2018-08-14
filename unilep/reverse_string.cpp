void reverse(char* str) {
    int length = 0;
    while(str[length++]);
    --length;

    int halfLen = length / 2;
    for(int i=0; i<halfLen; i++) {
        char temp = str[i];
        str[i] = str[length - i - 1];
        str[length - i - 1] = temp;
    }
}