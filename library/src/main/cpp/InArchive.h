/*
 * Copyright 2018 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef __A7ZIP_IN_ARCHIVE_H__
#define __A7ZIP_IN_ARCHIVE_H__

#include <include_windows/windows.h>
#include <Common/MyCom.h>
#include <Common/MyString.h>
#include <7zip/Archive/IArchive.h>

namespace a7zip {

class InArchive {
 public:
  InArchive(CMyComPtr<IInArchive> in_archive, AString format_name);

 public:
  const AString& GetFormatName();
  HRESULT GetNumberOfEntries(UInt32& number);
  HRESULT GetEntryPath(UInt32 index, BSTR* name);
  HRESULT ExtractEntry(UInt32 index, CMyComPtr<ISequentialOutStream> out_stream);

 private:
  CMyComPtr<IInArchive> in_archive;
  AString format_name;
};

}

#endif //__A7ZIP_IN_ARCHIVE_H__