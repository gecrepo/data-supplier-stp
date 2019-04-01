# data-supplier-stp
Данное дополнение для Cuba Platform приложений предоставляет возможность форматирования адресов с полным получением всей 
информации по обрабатываемому адресу, а так же предоставляет функциональность по подсказке вводимых адресов для пользователя. 

Ключевым компонентом аддона является класс-делегат по обработке данных:
*com.groupstp.datasupplier.core.bean.datasupplier.provider.DataProviderDelegate*

В дополнении на данный момент реализован только один такой делегат на основе сервиса DaData:
*com.groupstp.datasupplier.core.bean.datasupplier.provider.impl.dadata.DaDataProvider*
