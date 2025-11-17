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

# hae annetun tableWidgetin kaikki data listassa, jossa kukin rivi on omana listanaan
def tableWidgetData(tableWidget):

  # apu metodi tarkistamaan annettu widgetti ja hakemaan siitä data oikein
  # lisää widgettejä tarvittaessa
  def tarkistaWidget(widget):
    if isinstance(widget, QComboBox):
      value = widget.currentText()
    elif isinstance(widget, QSpinBox):
      value = widget.value()
    else:
      value = widget.text()
    return value

  data = []
  for row in range(tableWidget.rowCount()):
    row_data = []
    for column in range(tableWidget.columnCount()):
      item = tableWidget.cellWidget(row, column)
      if item is not None:
        value = tarkistaWidget(item)
      else:
        value = tableWidget.item(row, column).text()
      row_data.append(value)
    data.append(row_data)
  return data