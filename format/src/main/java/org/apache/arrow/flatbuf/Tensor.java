/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.arrow.flatbuf;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Tensor extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_25_2_10(); }
  public static Tensor getRootAsTensor(ByteBuffer _bb) { return getRootAsTensor(_bb, new Tensor()); }
  public static Tensor getRootAsTensor(ByteBuffer _bb, Tensor obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Tensor __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public byte typeType() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) : 0; }
  /**
   * The type of data contained in a value cell. Currently only fixed-width
   * value types are supported, no strings or nested types
   */
  public Table type(Table obj) { int o = __offset(6); return o != 0 ? __union(obj, o + bb_pos) : null; }
  /**
   * The dimensions of the tensor, optionally named
   */
  public org.apache.arrow.flatbuf.TensorDim shape(int j) { return shape(new org.apache.arrow.flatbuf.TensorDim(), j); }
  public org.apache.arrow.flatbuf.TensorDim shape(org.apache.arrow.flatbuf.TensorDim obj, int j) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int shapeLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public org.apache.arrow.flatbuf.TensorDim.Vector shapeVector() { return shapeVector(new org.apache.arrow.flatbuf.TensorDim.Vector()); }
  public org.apache.arrow.flatbuf.TensorDim.Vector shapeVector(org.apache.arrow.flatbuf.TensorDim.Vector obj) { int o = __offset(8); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  /**
   * Non-negative byte offsets to advance one value cell along each dimension
   * If omitted, default to row-major order (C-like).
   */
  public long strides(int j) { int o = __offset(10); return o != 0 ? bb.getLong(__vector(o) + j * 8) : 0; }
  public int stridesLength() { int o = __offset(10); return o != 0 ? __vector_len(o) : 0; }
  public LongVector stridesVector() { return stridesVector(new LongVector()); }
  public LongVector stridesVector(LongVector obj) { int o = __offset(10); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer stridesAsByteBuffer() { return __vector_as_bytebuffer(10, 8); }
  public ByteBuffer stridesInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 10, 8); }
  /**
   * The location and size of the tensor's data
   */
  public org.apache.arrow.flatbuf.Buffer data() { return data(new org.apache.arrow.flatbuf.Buffer()); }
  public org.apache.arrow.flatbuf.Buffer data(org.apache.arrow.flatbuf.Buffer obj) { int o = __offset(12); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }

  public static void startTensor(FlatBufferBuilder builder) { builder.startTable(5); }
  public static void addTypeType(FlatBufferBuilder builder, byte typeType) { builder.addByte(0, typeType, 0); }
  public static void addType(FlatBufferBuilder builder, int typeOffset) { builder.addOffset(1, typeOffset, 0); }
  public static void addShape(FlatBufferBuilder builder, int shapeOffset) { builder.addOffset(2, shapeOffset, 0); }
  public static int createShapeVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startShapeVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addStrides(FlatBufferBuilder builder, int stridesOffset) { builder.addOffset(3, stridesOffset, 0); }
  public static int createStridesVector(FlatBufferBuilder builder, long[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addLong(data[i]); return builder.endVector(); }
  public static void startStridesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addData(FlatBufferBuilder builder, int dataOffset) { builder.addStruct(4, dataOffset, 0); }
  public static int endTensor(FlatBufferBuilder builder) {
    int o = builder.endTable();
    builder.required(o, 6);  // type
    builder.required(o, 8);  // shape
    builder.required(o, 12);  // data
    return o;
  }
  public static void finishTensorBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedTensorBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Tensor get(int j) { return get(new Tensor(), j); }
    public Tensor get(Tensor obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
