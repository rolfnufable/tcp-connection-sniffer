/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class jpcap_JpcapCaptor */

#ifndef _Included_jpcap_JpcapCaptor
#define _Included_jpcap_JpcapCaptor
#ifdef __cplusplus
extern "C" {
#endif
#undef jpcap_JpcapCaptor_MAX_NUMBER_OF_INSTANCE
#define jpcap_JpcapCaptor_MAX_NUMBER_OF_INSTANCE 255L
/* Inaccessible static: instanciatedFlag */
/*
 * Class:     jpcap_JpcapCaptor
 * Method:    nativeOpenLive
 * Signature: (Ljava/lang/String;III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_JpcapCaptor_nativeOpenLive
  (JNIEnv *, jobject, jstring, jint, jint, jint);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    nativeOpenOffline
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_JpcapCaptor_nativeOpenOffline
  (JNIEnv *, jobject, jstring);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    nativeClose
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_nativeClose
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    getDeviceList
 * Signature: ()[Ljpcap/NetworkInterface;
 */
JNIEXPORT jobjectArray JNICALL Java_jpcap_JpcapCaptor_getDeviceList
  (JNIEnv *, jclass);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    getPacket
 * Signature: ()Ljpcap/packet/Packet;
 */
JNIEXPORT jobject JNICALL Java_jpcap_JpcapCaptor_getPacket
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    processPacket
 * Signature: (ILjpcap/PacketReceiver;)I
 */
JNIEXPORT jint JNICALL Java_jpcap_JpcapCaptor_processPacket
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    loopPacket
 * Signature: (ILjpcap/PacketReceiver;)I
 */
JNIEXPORT jint JNICALL Java_jpcap_JpcapCaptor_loopPacket
  (JNIEnv *, jobject, jint, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    setNonBlockingMode
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_setNonBlockingMode
  (JNIEnv *, jobject, jboolean);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    isNonBlockinMode
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_jpcap_JpcapCaptor_isNonBlockinMode
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    breakLoop
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_breakLoop
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    setPacketReadTimeout
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_jpcap_JpcapCaptor_setPacketReadTimeout
  (JNIEnv *, jobject, jint);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    getPacketReadTimeout
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jpcap_JpcapCaptor_getPacketReadTimeout
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    setFilter
 * Signature: (Ljava/lang/String;Z)V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_setFilter
  (JNIEnv *, jobject, jstring, jboolean);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    setJpcapFilter
 * Signature: (Ljpcap/JpcapFilter;)V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_setJpcapFilter
  (JNIEnv *, jobject, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    updateStat
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jpcap_JpcapCaptor_updateStat
  (JNIEnv *, jobject);

/*
 * Class:     jpcap_JpcapCaptor
 * Method:    getErrorMessage
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_jpcap_JpcapCaptor_getErrorMessage
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
