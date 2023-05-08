# train-result.md

## 原始 apichecker.pkl 的分类模型效果
```
Total line 501971, Black: 38698
Training Classification Model 1: <class 'sklearn.naive_bayes.BernoulliNB'>
Precision 0.330938
RECALL 0.770596
Training Classification Model 2: <class 'sklearn.ensemble._forest.RandomForestClassifier'>
Precision 0.983221
RECALL 0.965526
Training Classification Model 3: <class 'sklearn.tree._classes.DecisionTreeClassifier'>
Precision 0.969297
RECALL 0.968314
Training Classification Model 4: <class 'sklearn.linear_model._base.LinearRegression'>
Precision 0.959259
RECALL 0.787833
Training Classification Model 5: <class 'sklearn.neighbors._classification.KNeighborsClassifier'>
Precision 0.973388
RECALL 0.964259
Training Classification Model 6: <class 'sklearn.svm._classes.SVC'>
Precision 0.970105
RECALL 0.913054
Training Classification Model 7: <class 'sklearn.neural_network._multilayer_perceptron.MLPClassifier'>
Precision 0.977011
RECALL 0.969582
Training Classification Model 8: <class 'sklearn.neural_network._multilayer_perceptron.MLPClassifier'>
Precision 0.976294
RECALL 0.970849
```


```
Total line 501971, Black: 38698
[0] Training Classification Model BernoulliNB
    saved to ../output\BernoulliNB.model.pkl
    Precision = 0.330938,  Recall = 0.770596,  F1 = 0.463026,  cost = 2.760
[1] Training Classification Model LinearRegression
    saved to ../output\LinearRegression.model.pkl
    Precision = 0.959259,  Recall = 0.787833,  F1 = 0.865136,  cost = 6.500
[2] Training Classification Model RandomForestClassifier
    saved to ../output\RandomForestClassifier.model.pkl
    Precision = 0.983226,  Recall = 0.965779,  F1 = 0.974425,  cost = 26.313
[3] Training Classification Model DecisionTreeClassifier
    saved to ../output\DecisionTreeClassifier.model.pkl
    Precision = 0.968077,  Recall = 0.968568,  F1 = 0.968322,  cost = 30.484
[4] Training Classification Model KNeighborsClassifier
    saved to ../output\KNeighborsClassifier.model.pkl
    Precision = 0.973388,  Recall = 0.964259,  F1 = 0.968802,  cost = 642.317
[5] Training Classification Model MLPClassifier
    saved to ../output\MLPClassifier.model.pkl
    Precision = 0.982714,  Recall = 0.965526,  F1 = 0.974044,  cost = 442.604
[6] Training Classification Model MLPClassifier_2
    saved to ../output\MLPClassifier_2.model.pkl
    Precision = 0.978244,  Recall = 0.968821,  F1 = 0.973510,  cost = 1110.077
[7] Training Classification Model GradientBoostingClassifier
    saved to ../output\GradientBoostingClassifier.model.pkl
    Precision = 0.964446,  Recall = 0.873257,  F1 = 0.916589,  cost = 692.927
[8] Training Classification Model HistGradientBoostingClassifier
    saved to ../output\HistGradientBoostingClassifier.model.pkl
    Precision = 0.964761,  Recall = 0.881369,  F1 = 0.921182,  cost = 22.514
```

```
Total line 501971, Black: 38698,  features: 242
[0] Training Classification Model BernoulliNB
    train = 451773,  test = 50198
    saved to ../output\BernoulliNB.model.pkl
    Precision = 0.330938,  Recall = 0.770596,  F1 = 0.463026,  train_cost = 2.226, predict_cost = 0.267
[1] Training Classification Model LinearRegression
    train = 451773,  test = 50198
    saved to ../output\LinearRegression.model.pkl
    Precision = 0.959259,  Recall = 0.787833,  F1 = 0.865136,  train_cost = 6.884, predict_cost = 0.137
[2] Training Classification Model RandomForestClassifier
    train = 451773,  test = 50198
    saved to ../output\RandomForestClassifier.model.pkl
    Precision = 0.983234,  Recall = 0.966286,  F1 = 0.974687,  train_cost = 20.753, predict_cost = 0.334
[3] Training Classification Model DecisionTreeClassifier
    train = 451773,  test = 50198
    saved to ../output\DecisionTreeClassifier.model.pkl
    Precision = 0.968338,  Recall = 0.969075,  F1 = 0.968706,  train_cost = 29.741, predict_cost = 0.191
[4] Training Classification Model HistGradientBoostingClassifier
    train = 451773,  test = 50198
    saved to ../output\HistGradientBoostingClassifier.model.pkl
    Precision = 0.964761,  Recall = 0.881369,  F1 = 0.921182,  train_cost = 13.506, predict_cost = 0.552
```