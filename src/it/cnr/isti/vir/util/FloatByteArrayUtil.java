/*******************************************************************************
 * Copyright (c) 2013, Fabrizio Falchi (NeMIS Lab., ISTI-CNR, Italy)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package it.cnr.isti.vir.util;

public class FloatByteArrayUtil {
	private static final int MASK = 0xff;
	

	/**
	 * convert byte array (of size 4) to float
	 * @param test
	 * @return
	 */
	public static final float byteArrayToFloat(byte test[]) {
		int bits = 0;
		int i = 0;
		for (int shifter = 3; shifter >= 0; shifter--) {
			bits |= ((int) test[i] & MASK) << (shifter * 8);
			i++;
		}

		return Float.intBitsToFloat(bits);
	}
	
	public static final float byteArrayToFloat(byte byteArray[], int byteOffset) {
		int bits = 0;
		int i = 0;
		for (int shifter = 3; shifter >= 0; shifter--) {
			bits |= ((int) byteArray[i+byteOffset] & MASK) << (shifter * 8);
			i++;
		}

		return Float.intBitsToFloat(bits);
	}

	
	public static final float[] byteArrayToFloatArray(byte byteArr[], int byteOffset, int nFloats) {
		float[] arr = new float[nFloats];
		for ( int i=0; i<arr.length; i++) {
			arr[i]=byteArrayToFloat(byteArr, byteOffset+8*i);
		}
		return arr;
	}
	
	public static final byte[] floatToByteArray(float f) {
		int i = Float.floatToRawIntBits(f);
		return intToByteArray(i);
	}
	
	public static final int floatToByteArray(float f, byte[] byteArray, int byteOffset) {
		return intToByteArray(Float.floatToRawIntBits(f), byteArray, byteOffset );
	}
	
	public static final int floatArrayToByteArray(float[] f, byte[] byteArray, int byteOffset) {
		int offset = byteOffset;
		for ( int i=0; i<f.length; i++) {
			offset = intToByteArray(Float.floatToRawIntBits(f[i]), byteArray, offset );
		}
		return offset;
	}


	/**
	 * convert int to byte array (of size 4)
	 * @param param
	 * @return
	 */
	public static final byte[] intToByteArray(int param) {
		byte[] result = new byte[4];
		for (int i = 0; i < 4; i++) {
			result[i] = (byte) ((param >>> (3 - i) * 8) & MASK);
		}
		return result;
	}
	
	public static final int intToByteArray(int param, byte[] byteArr, int byteOffset) {
		int offSet = byteOffset;
		for (int i = 0; i < 4; i++) {
			byteArr[offSet++] = (byte) ((param >>> (3 - i) * 8) & MASK);
		}
		return offSet;
	}

	/**
	 * convert byte array to String.
	 * @param byteArray
	 * @return
	 */
	public static final String byteArrayToString(byte[] byteArray) {
		StringBuilder sb = new StringBuilder("[");
		if(byteArray == null) {
			throw new IllegalArgumentException("byteArray must not be null");
		}
		int arrayLen = byteArray.length;
		for(int i = 0; i < arrayLen; i++) {
			sb.append(byteArray[i]);
			if(i == arrayLen - 1) {
				sb.append("]");
			} else{
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}