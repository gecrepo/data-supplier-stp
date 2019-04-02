# data-supplier-stp
Данное дополнение для Cuba Platform приложений предоставляет возможность форматирования адресов с полным получением всей 
информации по обрабатываемому адресу, а так же предоставляет функциональность по подсказке вводимых адресов для пользователя.

Ключевым компонентом аддона является класс-делегат по обработке данных:
*com.groupstp.datasupplier.core.bean.datasupplier.provider.DataProviderDelegate*

В дополнении на данный момент реализован только один такой делегат на основе сервиса DaData:
*com.groupstp.datasupplier.core.bean.datasupplier.provider.impl.dadata.DaDataProvider*

В проекте есть специальный компонент по подбору подсказок *com.groupstp.datasupplier.web.gui.components.AutocompleteTextField*,
так же может быть использован стандартный *com.haulmont.cuba.gui.components.SuggestionField*.

Так же есть вспомогательный класс *com.groupstp.datasupplier.web.util.AddressUiHelper* который предоставляющий доступ к функционалу с UI модуля в удобном виде.