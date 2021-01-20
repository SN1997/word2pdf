# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import os
import sys

file_path = os.path.abspath(__file__)
print(file_path)
# 获取当前文件所在的目录
cur_path = os.path.dirname(file_path)
print(cur_path)
# 获取项目所在路径
project_path = os.path.dirname(cur_path)
print(project_path)
# 把项目路径加入python搜索路径
sys.path.append(project_path)
from win32com.client import constants, gencache


def createPdf(wordPath, pdfPath):
    """
    word转pdf
    :param wordPath: word文件路径
    :param pdfPath:  生成pdf文件路径
    """
    print("word:" + wordPath);
    print("pdf:" + pdfPath);
    word = gencache.EnsureDispatch('Word.Application')
    doc = word.Documents.Open(wordPath, ReadOnly=1)
    doc.ExportAsFixedFormat(pdfPath,
                            constants.wdExportFormatPDF,
                            Item=constants.wdExportDocumentWithMarkup,
                            CreateBookmarks=constants.wdExportCreateHeadingBookmarks)
    word.Quit(constants.wdDoNotSaveChanges)


createPdf(sys.argv[1], sys.argv[2])
# Press the green button in the gutter to run the script.
#if __name__ == '__main__':
#    createPdf(sys.argv[1], sys.argv[2])
#     #    print_hi('PyCharm')
#    createPdf('C:\\Users\\Administrator\\Desktop\\initWord.docx', 'C:\\Users\\Administrator\\Desktop\\create.pdf')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
