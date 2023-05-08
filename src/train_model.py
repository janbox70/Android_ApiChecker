#!/usr/bin/python3
# coding:utf-8
"""
    comments here
"""
import os
from datetime import datetime

from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier, HistGradientBoostingClassifier
from sklearn.linear_model import LinearRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn import svm
# from catboost import CatBoostClassifier
from sklearn.naive_bayes import BernoulliNB
from sklearn.metrics import accuracy_score, recall_score, precision_score, f1_score
from sklearn.model_selection import KFold
from sklearn.neural_network import MLPClassifier
import numpy as np
# import lightgbm as lgb

import pickle as pkl

__author__ = 'apichecker'

classifiers = (
    "BernoulliNB",
    "LinearRegression",
    "RandomForestClassifier",
    "DecisionTreeClassifier",
    # "KNeighborsClassifier",
    # "SVC",            # not suitable for large dataset
    # "MLPClassifier",
    # "MLPClassifier_2",
    # "GradientBoostingClassifier",   # slower than HistGradientBoostingClassifier
    "HistGradientBoostingClassifier",
)


def create_classifier(name):
    if name == "BernoulliNB":
        clf = BernoulliNB()
    elif name == "RandomForestClassifier":
        clf = RandomForestClassifier(n_estimators=15)
    elif name == "DecisionTreeClassifier":
        clf = DecisionTreeClassifier()
    elif name == "KNeighborsClassifier":
        clf = KNeighborsClassifier(n_neighbors=5, weights='uniform', algorithm='auto')
    elif name == "SVC":
        clf = svm.SVC(gamma='auto')
    elif name == "MLPClassifier":
        clf = MLPClassifier(hidden_layer_sizes=(100,), solver='adam', alpha=0.0001)
    elif name == "MLPClassifier_2":
        clf = MLPClassifier(hidden_layer_sizes=(100, 75, 50, 20), solver='adam', alpha=0.0001)
    elif name == "GradientBoostingClassifier":
        clf = GradientBoostingClassifier(n_estimators=100, learning_rate=0.1, max_depth=3, random_state=0)
    elif name == "HistGradientBoostingClassifier":
        clf = HistGradientBoostingClassifier(learning_rate=0.1, max_depth=3, random_state=0)
    elif name == "LinearRegression":
        clf = LinearRegression()
    else:
        assert False

    return clf


def load_dataset():
    with open("../data/apichecker.pkl", "rb") as pklfile:
        X, y = pkl.load(pklfile)
        y = [int(_) for _ in y]
        total_count = len(X)
        black_count = len(list(filter(lambda _: _ == 1, y)))
        print("Total line %d, Black: %d,  features: %d" % (total_count, black_count, len(X[0])))
        # dump_freq(X, y)
        return X, y


def dump_freq(X, y):
    freq_counter = {}
    black_freq_counter = {}
    for x_line, y_line in zip(X, y):
        for i, feature in enumerate(x_line):
            if feature == 1:
                if i not in freq_counter:
                    freq_counter[i] = 1
                    black_freq_counter[i] = 0
                else:
                    freq_counter[i] += 1

                if y_line == 1:
                    black_freq_counter[i] += 1

    for i in sorted(freq_counter.keys()):
        print("[{}]: freq={} black={}".format(i, freq_counter[i], black_freq_counter[i]))


def do_train(name, X_train, y_train, X_test, y_test):
    clf = create_classifier(name)
    start = datetime.now()
    clf.fit(X_train, y_train)

    filename = os.path.join("../output", name + ".model.pkl")
    with open(filename, "wb") as mf:
        pkl.dump(clf, mf)
        print("    saved to " + filename)

    train_cost = (datetime.now() - start).total_seconds()
    start = datetime.now()
    predict = clf.predict(X_test)
    predict = [1 if p > 0.5 else 0 for p in predict]
    # print(predict)

    print("    Precision = %f,  Recall = %f,  F1 = %f,  train_cost = %.3f, predict_cost = %.3f" % (
        precision_score(y_test, predict),
        recall_score(y_test, predict),
        f1_score(y_test, predict),
        train_cost,
        (datetime.now() - start).total_seconds()))
    pass


def main():
    X, y = load_dataset()

    X = np.array(X)
    y = np.array(y)

    for i, name in enumerate(classifiers):
        kf = KFold(n_splits=10)
        round = 1
        for train_index, test_index in kf.split(X, y):
            round += 1
            X_train, X_test = X[train_index], X[test_index]
            y_train, y_test = y[train_index], y[test_index]

            print("[%d] Training Classification Model %s" % (i, name))
            print("    train = {},  test = {}".format(len(y_train), len(y_test)))
            do_train(name, X_train, y_train, X_test, y_test)

            break
        pass


if __name__ == "__main__":
    main()
