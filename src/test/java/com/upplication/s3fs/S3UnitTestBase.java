package com.upplication.s3fs;

import static com.upplication.s3fs.S3FileSystemProvider.AMAZON_S3_FACTORY_CLASS;

import java.net.URI;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.upplication.s3fs.util.AmazonS3ClientMock;
import com.upplication.s3fs.util.AmazonS3MockFactory;

public class S3UnitTestBase {

    @BeforeClass
    public static void setProperties() {
        System.setProperty(AMAZON_S3_FACTORY_CLASS, "com.upplication.s3fs.util.AmazonS3MockFactory");
    }

    @After
    public void closeMemory() {
        AmazonS3ClientMock client = AmazonS3MockFactory.getAmazonClientMock();
        client.clear();
        for (S3FileSystem s3FileSystem : S3FileSystemProvider.getFilesystems().values()) {
            try {
                s3FileSystem.close();
            } catch (Exception e) {
                //ignore
            }
        }
    }
}