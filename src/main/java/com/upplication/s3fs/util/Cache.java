package com.upplication.s3fs.util;

import com.upplication.s3fs.S3FileAttributes;

public class Cache {

    /**
     * check if the cache of the S3FileAttributes is still valid
     *
     * @param cache          int cache time of the fileAttributes in milliseconds
     * @param fileAttributes S3FileAttributes to check if is still valid, can be null
     * @return true or false, if cache are -1 and fileAttributes are not null then always return true
     */
    public boolean isInTime(int cache, S3FileAttributes fileAttributes) {
        if (fileAttributes == null) {
            return false;
        }

        if (cache == -1) {
            return true;
        }

        return getCurrentTime() - cache <= fileAttributes.getCacheCreated();
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
