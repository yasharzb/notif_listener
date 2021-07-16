import random, sys
from MaskDetector import mask_image
from PIL import Image
from numpy import asarray
import datetime


def mask_detector(file_path):
    image = Image.open(file_path)
    img_array = asarray(image)

    result = mask_image(img_array, datetime.datetime.now())
    if result == 'No Mask':
        return False
    else:
        return True


pic_path = sys.argv[1]

result = mask_detector(file_path=pic_path)
print(result)
