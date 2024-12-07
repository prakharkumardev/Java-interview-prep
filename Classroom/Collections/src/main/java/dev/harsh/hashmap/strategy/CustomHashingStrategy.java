package dev.harsh.hashmap.strategy;

public class CustomHashingStrategy implements HashingStrategy{
    private static final int POW_NO = 7;
    private static final int MOD = (int)(1e9  + 7);
    @Override
    public int getHashValue(String key) {
        int size = key.length();
        long output = 0;
        for(int i = 0 ; i < size ; ++i){
            output = (output + ((long)key.charAt(i) * (long)Math.pow(POW_NO,i)) % MOD)% MOD;
        }
        return (int)output;
    }
}
