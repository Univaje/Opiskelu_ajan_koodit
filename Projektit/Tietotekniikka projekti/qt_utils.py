from PyQt5.QtCore import *  # type: ignore
from PyQt5.QtGui import *  # type: ignore
from PyQt5.QtWidgets import *  # type: ignore

# laita annettu data QComboboxiin ja palauta widgetti
def tkComboBox(data=[]):
  combo = QComboBox()
  combo.addItems(data)
  return combo

# laita annettu data tavalliseen tablewidgettiin ja palauta se
def defaultItem(data=0.0):
  item = QTableWidgetItem()
  item.setData(0, data)
  return item
