// Copyright (c) Microsoft Corporation
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

#include <pch.h>
#include <XSAPI_Integration.h>
//#include <Social_Integration.h>
#include <Game_Integration.h>
#include <Game_Integration_JNI.h>
#include "SocialLayer_JNI.h"

static jobject g_socialLayerInstance = nullptr;

extern "C"
{
    JNIEXPORT void JNICALL Java_xbl_sample_android_layers_SocialLayer_InitializeNativeVars(
            JNIEnv* env,
            jobject instance)
    {
        g_socialLayerInstance = env->NewGlobalRef(instance);
    }

    JNIEXPORT void JNICALL Java_xbl_sample_android_layers_SocialUsersLayer_InitializeNativeVars(
            JNIEnv* env,
            jobject instance)
    {

    }

    JNIEXPORT void JNICALL Java_xbl_sample_android_layers_SocialGroupsLayer_InitializeNativeVars(
            JNIEnv* env,
            jobject instance)
    {

    }

    JNIEXPORT void JNICALL Java_xbl_sample_android_layers_SocialProfileViewLayer_InitializeNativeVars(
            JNIEnv* env,
            jobject instance)
    {

    }

    JNIEXPORT void JNICALL Java_xbl_sample_android_layers_SocialGroupViewLayer_InitializeNativeVars(
            JNIEnv* env,
            jobject instance)
    {

    }
}