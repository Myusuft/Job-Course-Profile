package com.firejobcourse.apps;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

//public class AppGlideModule {
//}
//@GlideModule
//public final class MyAppGlideModule extends AppGlideModule {
//    @Override
//    public void registerComponents(Context context, Glide glide, Registry registry) {
//        // Register FirebaseImageLoader to handle StorageReference
//        registry.append(StorageReference.class, InputStream.class,
//                new FirebaseImageLoader.Factory());
//    }
//}

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class MyAppGlideModule extends AppGlideModule {

}
