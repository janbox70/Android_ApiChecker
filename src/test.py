# coding:utf-8

import json

import numpy as np
import pandas as pd
import pickle as pkl
from collections import OrderedDict

col_names = ["Restricted API", "Highly-Correlation API", "Sensitive Operation API", "Union"]


def dump_sorted_set(name: str, data: set):
    print("{}: {}".format(name, len(data)))
    for item in sorted(data):
        print(item)


def test_api():
    df = pd.read_csv("../data/API_Set.csv", dtype=str, na_values="", keep_default_na=False, na_filter=False)
    print(df.shape)

    apis = set()
    classes = dict()
    for col in col_names:
        for i, api in df[col].items():
            if api is not None and api != '':
                apis.add(api)
                parts = api.split(' ')
                if parts[0] not in classes:
                    classes[parts[0]] = set()
                classes[parts[0]].add(parts[1])

    dump_sorted_set("apis", apis)

    # odict = OrderedDict((k, [v for v in sorted(classes[k])]) for k in sorted(classes.keys()))
    # print(json.dumps(odict, indent=2))


if __name__ == "__main__":
    test_api()
    # test_pkl()

