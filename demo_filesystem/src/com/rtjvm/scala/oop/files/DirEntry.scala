package com.rtjvm.scala.oop.files

abstract class DirEntry(val parentPath: String, val name: String) {
  def path : String = {
    val conditionalSeparator =
      if(Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR

    s"$parentPath$conditionalSeparator$name"
  }
  def asDirectory: Directory
  def isDirectory: Boolean
  def asFile: File
  def isFile: Boolean
  def getType: String
}
