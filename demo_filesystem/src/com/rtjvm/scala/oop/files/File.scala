package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FilesystemException

class File(override val parentPath: String, override val name: String, val contents: String)
  extends DirEntry(parentPath, name) {

  def setContents(newContents: String): File =
    new File(parentPath, name, newContents)

  def appendContents(newContents: String): File =
    setContents(contents + "\n" + newContents)


  override def asDirectory: Directory = throw new FilesystemException("A file cannot be converted to a directory!")

    def asFile: File = this

    override def getType: String = "File"

    def isDirectory: Boolean = false

    def isFile: Boolean = true
}

object File{
  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}