from net.fabricmc.fabric.api.item.v1 import FabricItemSettings
from net.fabricmc.fabric.api.object.builder.v1.block import FabricBlockSettings

from fr.anatom3000.gwwhit import GWWHIT, CustomItemGroups
from fr.anatom3000.gwwhit.block import SimpleBlock
from fr.anatom3000.gwwhit.item import SimpleItem
from fr.anatom3000.gwwhit.registry import BlockRegistry, ItemRegistry
from fr.anatom3000.gwwhit.util import PyUtils

GWWHIT.LOGGER.info('[GWWHIT] Loading python stuff')

# noinspection PyTypeChecker
pyBlock = SimpleBlock(
	FabricBlockSettings
		.of(PyUtils.getMaterial('stone'))
		.collidable(False)
		.drops(PyUtils.makeIdentifier('minecraft', 'stone'))
		.luminance(10)
)

BlockRegistry.put('pyblock', pyBlock)
ItemRegistry.put(
	'pyblock',
	SimpleItem.fromBlock(
		pyBlock,
		FabricItemSettings().group(CustomItemGroups.GWWHIT_GROUP)
	)
)

GWWHIT.LOGGER.info('[GWWHIT] Python stuff loaded!')
